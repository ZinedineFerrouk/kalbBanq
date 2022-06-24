package com.kalbanq_servlet.servlet;

import com.kalbanq_servlet.entity.Banker;
import com.kalbanq_servlet.entity.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccountIndexServlet", urlPatterns ={"/customer/index"})
public class AccountIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        Banker banker = customer.getBanker();

        if (customer != null) {
            request.setAttribute("customer", customer);
            request.setAttribute("banker", banker);

            System.out.println(customer.getId());
            //this.doGet(request, response);
        }
        this.getServletContext().getRequestDispatcher("/customer-index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

