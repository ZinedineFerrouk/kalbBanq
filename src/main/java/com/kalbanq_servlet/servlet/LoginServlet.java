package com.kalbanq_servlet.servlet;

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

        String identifier = request.getParameter("identifier");
        String password = request.getParameter("password");

        if (identifier == null || password == null || identifier.isEmpty() || password.isEmpty()) {
            request.setAttribute("message", "Veuillez renseigner les champs");
            // request.setAttribute("variables", errors);
            doGet(request, response);
        }

        JSONObject user;
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

            // if (true){
            //     return;
            // }

            long responseCode = (long) object.get("status_code");
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            }
            user = (JSONObject) ((JSONArray) object.get("data")).get(0);
            response.getWriter().println(user.toJSONString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        if (!user.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            System.out.println(session);
            // response.sendRedirect("/mon-espace");
        } else {
            // Show error like "Login failed, unknown user, try again.".
            request.setAttribute("message", "Compte invalide");
            doGet(request,response);
        }
//
//        if (session.getAttribute("user") == null) {
//            response.sendRedirect(request.getContextPath() + "/login"); // Not logged in, redirect to login page.
//        } else {
//            chain.doFilter(request, response); // Logged in, just continue chain.
//        }
    }
}
