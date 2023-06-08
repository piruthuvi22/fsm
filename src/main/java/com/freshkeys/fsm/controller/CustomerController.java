package com.freshkeys.fsm.controller;

import com.freshkeys.fsm.entity.Customer;
import com.freshkeys.fsm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping("/add-customer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.saveCustomer(customer);
    }



    @GetMapping("/get-customers")
    public List<Customer> getAllCustomers() {
        return service.getCustomers();
    }

    @GetMapping("/get-customer-by-id/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return service.getCustomerById(id);
    }



    @PutMapping("/update-customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return service.updateCustomer(customer);
    }

    @DeleteMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return service.deleteCustomer(id);
    }
}
