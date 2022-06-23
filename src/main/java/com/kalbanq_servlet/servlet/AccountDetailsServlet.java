package com.kalbanq_servlet.servlet;

import com.kalbanq_servlet.entity.Account;
import com.kalbanq_servlet.entity.AccountType;
import com.kalbanq_servlet.entity.PaymentType;
import com.kalbanq_servlet.service.utils.Utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@WebServlet(name = "AccountDetailsServlet", value = "/customer/account/details/")
public class AccountDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") == null){
            response.sendRedirect("/customer/accounts");
            return;
        }
        UUID id = UUID.fromString(request.getParameter("id"));

        URL url = new URL("http://localhost:8080/api/account/get-account/" + id);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.connect();

        try {
            JSONObject object;
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

            if (responseCode != 200L){
                request.setAttribute("message", object.get("data"));
                this.getServletContext().getRequestDispatcher("/customer-accounts.jsp").forward(request, response);
                return;
            }

            JSONObject data = (JSONObject) ((JSONArray) object.get("data")).get(0);
            Account account = new Account();
            account.setId(UUID.fromString((String) data.get("id")));
            account.setAccountNumber((String) data.get("accountNumber"));
            account.setSold((double) data.get("sold"));
            account.setAccountLimit((long) data.get("accountLimit"));
            account.setDownPayment((double) data.get("downPayment"));
            account.setDawnPaymentType(PaymentType.valueOf((String) data.get("dawnPaymentType")));
            account.setCreatedAt(Utils.dateFromString((String) data.get("createdAt")));
            if (data.get("updatedAt") != null){
                account.setUpdatedAt(Utils.dateFromString((String) data.get("updatedAt")));
            }
            JSONObject accountTypeData = (JSONObject) data.get("accountType");
            AccountType accountType = new AccountType();
            accountType.setId(UUID.fromString((String) accountTypeData.get("id")));
            accountType.setName((String) accountTypeData.get("name"));
            accountType.setCreatedAt(Utils.dateFromString((String) accountTypeData.get("createdAt")));
            if (data.get("updatedAt") != null){
                accountType.setUpdatedAt(Utils.dateFromString((String) accountTypeData.get("updatedAt")));
            }

            account.setAccountType(accountType);
            request.setAttribute("account", account);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.getServletContext().getRequestDispatcher("/customer-account-details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
