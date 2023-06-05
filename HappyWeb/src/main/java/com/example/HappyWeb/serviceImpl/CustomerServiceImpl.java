package com.example.HappyWeb.serviceImpl;

import com.example.HappyWeb.entity.Customer;
import com.example.HappyWeb.exception.CustomerException;
import com.example.HappyWeb.repository.CustomerRepository;
import com.example.HappyWeb.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()->new CustomerException("Customer not found"));

        return customer;
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(()->new CustomerException("Customer not found"));

        existingCustomer.setCustomerID(customer.getCustomerID());
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setLocation(customer.getLocation());

        Customer updateCustomer = customerRepository.save(existingCustomer);
        return updateCustomer;
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer deleteCustomer = customerRepository.findById(id)
                .orElseThrow(()->new CustomerException("Not found"));

        customerRepository.delete(deleteCustomer);

    }
}
