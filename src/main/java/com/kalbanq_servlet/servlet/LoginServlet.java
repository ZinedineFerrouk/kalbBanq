package com.kalbanq_servlet.servlet;

import com.kalbanq_servlet.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
