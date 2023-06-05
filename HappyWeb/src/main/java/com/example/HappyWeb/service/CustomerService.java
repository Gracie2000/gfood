package com.example.HappyWeb.service;

import com.example.HappyWeb.entity.Customer;
import com.example.HappyWeb.repository.CustomerRepository;

import java.util.List;

public interface CustomerService {
    //create
    Customer addCustomer(Customer customer);
    //read get all customers
    List<Customer> getAllCustomers();
    //get customer by id
    Customer getCustomerById(Long id);
    //update
    Customer updateCustomer(Long id, Customer customer);
    //delete
    void deleteCustomer(Long id);

}
