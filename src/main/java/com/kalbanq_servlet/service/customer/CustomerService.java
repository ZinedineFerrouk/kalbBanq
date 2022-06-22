package com.kalbanq_servlet.service.customer;

import com.kalbanq_servlet.entity.Banker;
import com.kalbanq_servlet.entity.Customer;
import com.kalbanq_servlet.entity.User;
import com.kalbanq_servlet.service.utils.Utils;
import org.json.simple.JSONObject;

public class CustomerService {
//    public Customer createCustomer(JSONObject customerData, JSONObject bankerData, JSONObject userData) throws Exception{
//        Customer customer = new Customer();
//        customer.setId((String) customerData.get("id"));
//        customer.setFirst_name((String) customerData.get("firstName"));
//        customer.setLast_name((String) customerData.get("lastName"));
//        customer.setGender((String) customerData.get("gender"));
//        customer.setEmail((String) customerData.get("email"));
//        customer.setAddress((String) customerData.get("address"));
//        customer.setPhone((String) customerData.get("phone"));
//        customer.setBirthdate(Utils.dateFromString((String) customerData.get("birthdate")));
//        JSONObject countryData = (JSONObject) customerData.get("country");
//        customer.setCountry((String) countryData.get("name"));
//
//        // BANKER
//        Banker banker = new Banker();
//        banker.setId((String) bankerData.get("id"));
//        banker.setFirst_name((String) bankerData.get("firstName"));
//        banker.setLast_name((String) bankerData.get("lastName"));
//        banker.setEmail((String) bankerData.get("email"));
//        banker.setGender((String) bankerData.get("gender"));
//
//        // USER
//        User user = new User();
//        user.setId((String) userData.get("id"));
//        user.setUser_token((String) userData.get("userToken"));
//        user.setRoles((String) userData.get("roles"));
//        user.setCreated_at(Utils.dateFromString((String) userData.get("createdAt")));
//        if (userData.get("updatedAt") != null){
//            user.setUpdated_at(Utils.dateFromString((String) userData.get("updatedAt")));
//        }
//
//        customer.setBanker(banker);
//        customer.setUser(user);
//        return customer;
//    }
}
