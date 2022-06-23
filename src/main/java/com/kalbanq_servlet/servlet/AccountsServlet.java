package com.kalbanq_servlet.servlet;

import com.kalbanq_servlet.entity.Account;
import com.kalbanq_servlet.entity.AccountType;
import com.kalbanq_servlet.entity.Customer;
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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "AccountsServlet", value = "/customer/accounts")
public class AccountsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<UUID, Account> accountMap = new HashMap<>();
        // Récupérer l'id du customer depuis la session
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        URL url = new URL("http://localhost:8080/api/account/get-accounts-by-customer_id/" + customer.getId());
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

            JSONArray data = (JSONArray) ((JSONArray) object.get("data")).get(0);
            for (int i = 0; i < data.size(); i++) {
                JSONObject accountData = (JSONObject) data.get(i);
                Account account = new Account();
                account.setId(UUID.fromString((String) accountData.get("id")));
                account.setAccountNumber((String) accountData.get("accountNumber"));
                account.setSold((double) accountData.get("sold"));
                account.setAccountLimit((long) accountData.get("accountLimit"));
                account.setDownPayment((double) accountData.get("downPayment"));
                account.setDawnPaymentType(PaymentType.valueOf((String) accountData.get("dawnPaymentType")));
                account.setCreatedAt(Utils.dateFromString((String) accountData.get("createdAt")));
                if (accountData.get("updatedAt") != null){
                    account.setUpdatedAt(Utils.dateFromString((String) accountData.get("updatedAt")));
                }
                JSONObject accountTypeData = (JSONObject) accountData.get("accountType");
                AccountType accountType = new AccountType();
                accountType.setId(UUID.fromString((String) accountTypeData.get("id")));
                accountType.setName((String) accountTypeData.get("name"));
                accountType.setCreatedAt(Utils.dateFromString((String) accountTypeData.get("createdAt")));
                if (accountData.get("updatedAt") != null){
                    accountType.setUpdatedAt(Utils.dateFromString((String) accountTypeData.get("updatedAt")));
                }

                account.setAccountType(accountType);
                accountMap.put(account.getId(), account);
            }
            System.out.println(accountMap.size());

        }catch (Exception e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("accounts", accountMap);
        this.getServletContext().getRequestDispatcher("/customer-accounts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
