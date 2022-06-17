package com.kalbanq_servlet.service.customer;

import javax.json.Json;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class CustomerService {
    // Fonction qui fait un appel à l'API pour récupérer un client selon son ID
    public int getCustomer(String id) throws Exception{
        String url = "http://127.0.0.1:8080/api/customer/get-customer/" + id;
        URL urlObj = new URL(url);
        HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

        httpCon.setRequestMethod("GET");
        return httpCon.getResponseCode();
    }
}
