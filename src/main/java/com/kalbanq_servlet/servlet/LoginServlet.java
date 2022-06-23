package com.kalbanq_servlet.servlet;

import com.kalbanq_servlet.entity.Banker;
import com.kalbanq_servlet.entity.Customer;
import com.kalbanq_servlet.entity.User;
import com.kalbanq_servlet.service.utils.Utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public void init() {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("customer") != null) {
//            session.invalidate();
            response.sendRedirect("/customer/index");
            return;
        }
        this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();

        String identifier = request.getParameter("identifier");
        String password = request.getParameter("password");

        if (identifier == null || password == null || identifier.isEmpty() || password.isEmpty()) {
            request.setAttribute("message", "Veuillez renseigner les champs");
            this.doGet(request, response);
        }

        JSONObject data;
        User user;
        Banker banker;
        Customer customer = new Customer();

        try {
            URL url = new URL("http://127.0.0.1:8080/api/auth/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("login_id", identifier);
            jsonBody.put("password", password);

            // N'utilise pas le os.close car dans un try closable
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonBody.toJSONString().getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            JSONObject object;
            // BufferedReader => lis un tableau de bytes
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder stringRes = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    stringRes.append(responseLine.trim());
                }
                object = (JSONObject) new JSONParser().parse(stringRes.toString());
            }

            long responseCode = (long) object.get("status_code");
            if (responseCode != 200) {
                // Renvoyer l'erreur de l'api
                request.setAttribute("message", object.get("data"));
                doGet(request, response);
                return;
            }
            data = (JSONObject) ((JSONArray) object.get("data")).get(0);

            customer.setId((String) data.get("id"));
            customer.setFirst_name((String) data.get("firstName"));
            customer.setLast_name((String) data.get("lastName"));
            customer.setGender((String) data.get("gender"));
            customer.setEmail((String) data.get("email"));
            customer.setAddress((String) data.get("address"));
            customer.setPhone((String) data.get("phone"));
            customer.setBirthdate(Utils.dateFromString((String) data.get("birthdate")));
            JSONObject countryData = (JSONObject) data.get("country");
            customer.setCountry((String) countryData.get("name"));

            JSONObject bankerData = (JSONObject) data.get("banker");
            banker = new Banker();
            banker.setFirst_name((String) bankerData.get("firstName"));
            banker.setLast_name((String) bankerData.get("lastName"));
            banker.setEmail((String) bankerData.get("email"));
            banker.setGender((String) bankerData.get("gender"));

            JSONObject userData = (JSONObject) data.get("user");
            user = new User();
            user.setId((String) userData.get("id"));
            user.setUser_token((String) userData.get("userToken"));
            user.setRoles((String) userData.get("roles"));
            user.setCreated_at(Utils.dateFromString((String) userData.get("createdAt")));
            if (userData.get("updatedAt") != null){
                user.setUpdated_at(Utils.dateFromString((String) userData.get("updatedAt")));
            }

            customer.setBanker(banker);
            customer.setUser(user);
            // System.out.println(customer.getBanker());

            response.getWriter().println(data.toJSONString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (!data.isEmpty()) {
            session.setAttribute("customer", customer);
            System.out.println(session.getAttribute("customer"));
            response.sendRedirect("/customer/index");
        } else {
            // Show error like "Login failed, unknown data, try again.".
            request.setAttribute("message", "Compte invalide");
            doGet(request,response);
        }
    }
}
