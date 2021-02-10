/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routinejackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import custom.util.wrappers.CustomerWrapper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SharpSchnitzel
 */
public class RoutineJackson {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try { 
            Map<String, String> customer = new LinkedHashMap<>();
            List<Map<String, String>> customersList = new ArrayList<>();
            
            customer.put("last_name", "Korvin-Krukovskaya");
            customer.put("first_name", "Sofya");
            customer.put("middle_name", "Vasilyevna");
            customer.put("birth_date", "15-01-1850");
            customer.put("position", "Mathematician");
            
            customersList.add(new LinkedHashMap<>(customer));
            customer.clear();
            
            customer.put("last_name", "Washington");
            customer.put("first_name", "George");
            customer.put("birth_date", "30-04-1789");
            customer.put("position", "Mr. President");
            
            customersList.add(new LinkedHashMap<>(customer));
            customer.clear();
            
            CustomerWrapper customersObj = new CustomerWrapper(customersList);
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(customersObj);
            System.out.println("[-- Object to JSON...]\n");
            System.out.println(jsonString);
            
            System.out.println("\n[-- Vice versa...]\n");
            CustomerWrapper newCustomer = mapper.readValue(jsonString, CustomerWrapper.class);
            newCustomer.printCustomers();
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RoutineJackson.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //[-- Object to JSON...]
        //
        //{"list":[{"last_name":"Korvin-Krukovskaya","first_name":"Sofya","middle_name":"Vasilyevna","birth_date":"15-01-1850","position":"Mathematician"},{"last_name":"Washington","first_name":"George","birth_date":"30-04-1789","position":"Mr. President"}]}
        //
        //[-- Vice versa...]
        //
        //-- Customer #1 --
        //| Last name is Korvin-Krukovskaya
        //| First name is Sofya
        //| Middle name is Vasilyevna
        //| Birth date is 15-01-1850
        //| Position is Mathematician
        //------ EOL ------
        //
        //-- Customer #2 --
        //| Last name is Washington
        //| First name is George
        //| Birth date is 30-04-1789
        //| Position is Mr. President
        //------ EOL ------

    }
}
