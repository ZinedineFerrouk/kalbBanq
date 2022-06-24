package com.kalbanq_servlet.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ContactServlet", urlPatterns = "/contact")
public class ContactServlet extends HttpServlet {
    private String title;

    public void init() {
        title = "Page de contact";
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<String, String>();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || subject.isEmpty() || message.isEmpty()) {
            request.setAttribute("error", "Veuillez renseigner les champs");
            // request.setAttribute("variables", errors);
            doGet(request, response);
        }
        // Appel d'un service qui va checker l'identifiant & le mdp checkCreditentials(login, password){ traitement ici }
    }
}
