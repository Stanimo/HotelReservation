package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CustomerService {
    private static Map<String, Customer> customers = new HashMap<String, Customer>();

    public static void addCustomer(String email, String firstName, String lastName) {
        Customer currentCustomer = new Customer(firstName, lastName, email);
        customers.put(email, currentCustomer);
    }

    public static Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers() {
        Collection<Customer> allCustomers = new LinkedList<Customer>();
        for(Map.Entry<String, Customer> customer : customers.entrySet()) {
            allCustomers.add(customer.getValue());
        }
        return allCustomers;
    }

}
