package com.kalbanq_servlet.servlet;

import com.kalbanq_servlet.entity.User;
import com.kalbanq_servlet.service.customer.CustomerService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private String title;

    public void init() {
        title = "Page de connexion";
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // response.sendRedirect(request.getContextPath() + "/login.jsp");
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<String, String>();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "Veuillez renseigner les champs");
            // request.setAttribute("variables", errors);
            doGet(request, response);
        }

        try {
            URL url = new URL("http://127.0.0.1:8080/api/customer/getcustomer/" + login);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Récupère le code de reponse
            int responseCode = conn.getResponseCode();

            if (responseCode != 200){
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
                System.out.println(informationString);

                //JSON simple library Setup with Maven is used to convert strings to JSON
                JSONParser parse = new JSONParser();
                JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));

                //Get the first JSON object in the JSON array
                System.out.println(dataObject);

//                JSONObject userData = (JSONObject) dataObject.get(0);

//                System.out.println(userData.get("user"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        if (user != null) {
//            session.setAttribute("user", user);
//            System.out.println(user);
//        } else {
//            // Show error like "Login failed, unknown user, try again.".
//        }
//
//        if (session.getAttribute("user") == null) {
//            response.sendRedirect(request.getContextPath() + "/login"); // Not logged in, redirect to login page.
//        } else {
//            chain.doFilter(request, response); // Logged in, just continue chain.
//        }

            // System.out.println(response);
            // System.out.println(request);
        // Appel d'un service qui va checker l'identifiant & le mdp checkCreditentials(login, password){ traitement ici }
    }
}
