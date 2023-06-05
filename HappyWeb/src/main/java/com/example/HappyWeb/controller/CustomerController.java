package com.example.HappyWeb.controller;

import com.example.HappyWeb.entity.Customer;
import com.example.HappyWeb.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/g/customerTable")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //add customer(create)
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer add = customerService.addCustomer(customer);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    //get all customers
    @GetMapping()
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    //get by id
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }
    //update by id
    @PutMapping("{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id,@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.updateCustomer(id, customer), HttpStatus.OK);
    }

    //delete
    @DeleteMapping("{id}")
        public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
         customerService.deleteCustomer(id);
         return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
    }

}
