package com.kalbanq_servlet.servlet;

import com.kalbanq_servlet.entity.Banker;
import com.kalbanq_servlet.entity.Customer;
import com.kalbanq_servlet.entity.User;
import com.kalbanq_servlet.service.api.ApiService;
import com.kalbanq_servlet.service.utils.Utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final ApiService apiService;

    public LoginServlet(ApiService apiService) {
        this.apiService = apiService;
    }

    public void init() {}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // response.sendRedirect(request.getContextPath() + "/login.jsp");
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<String, String>();

        String identifier = request.getParameter("identifier");
        String password = request.getParameter("password");

        if (identifier == null || password == null || identifier.isEmpty() || password.isEmpty()) {
            request.setAttribute("message", "Veuillez renseigner les champs");
            // request.setAttribute("variables", errors);
            doGet(request, response);
        }

        JSONObject data;
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
            try (OutputStream os = conn.getOutputStream();) {
                byte[] input = jsonBody.toJSONString().getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            JSONObject object = null;
            // BufferedReader => lis un tableau de bytes
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder stringRes = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    stringRes.append(responseLine.trim());
                }
                object = (JSONObject) new JSONParser().parse(stringRes.toString());
            }

            long responseCode = (long) object.get("status_code");
            if (responseCode != 200) {
                // Renvoyer l'erreur de l'api
                throw new RuntimeException("HttpResponseCode: " + responseCode);
                // request.setAttribute("message", "Veuillez renseigner les champs");
                //System.out.println(object);
            }
            data = (JSONObject) ((JSONArray) object.get("data")).get(0);

            Customer customer = new Customer();
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
            Banker banker = new Banker();
            banker.setId((String) bankerData.get("id"));
            banker.setFirst_name((String) bankerData.get("firstName"));
            banker.setLast_name((String) bankerData.get("lastName"));
            banker.setEmail((String) bankerData.get("email"));
            banker.setGender((String) bankerData.get("gender"));

            JSONObject userData = (JSONObject) data.get("user");
            User user = new User();
            user.setId((String) userData.get("id"));
            user.setUser_token((String) userData.get("userToken"));
            user.setRoles((String) userData.get("roles"));
            user.setCreated_at(Utils.dateFromString((String) userData.get("createdAt")));
            if (userData.get("updatedAt") != null){
                user.setUpdated_at(Utils.dateFromString((String) userData.get("updatedAt")));
            }

            customer.setBanker(banker);
            customer.setUser(user);
            System.out.println(customer.getBanker());

            response.getWriter().println(data.toJSONString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        HttpSession session = request.getSession();
        if (!data.isEmpty()) {
            session.setAttribute("user", data);
//            session.setAttribute("customer", );
//            session.setAttribute("data", data);
            // System.out.println(session);
            // response.sendRedirect("/mon-espace");
        } else {
            // Show error like "Login failed, unknown data, try again.".
            request.setAttribute("message", "Compte invalide");
            doGet(request,response);
        }
//
//        if (session.getAttribute("data") == null) {
//            response.sendRedirect(request.getContextPath() + "/login"); // Not logged in, redirect to login page.
//        } else {
//            chain.doFilter(request, response); // Logged in, just continue chain.
//        }
    }
}
