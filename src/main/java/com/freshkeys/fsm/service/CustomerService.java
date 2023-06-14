package com.freshkeys.fsm.service;

import com.freshkeys.fsm.entity.Customer;
import com.freshkeys.fsm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer saveCustomer(Customer customer){
        return repository.save(customer);
    }

    public List<Customer> getCustomers(){
        return repository.findAll();
    }

    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        return repository.findByPhonenumber(phoneNumber);
    }
    public Customer getCustomerById(int id){
        return repository.findById(id).orElse(null);
    }



    public String deleteCustomer(int id){
        repository.deleteById(id);
        return "Customer removed " + id;
    }

    public Customer updateCustomer(Customer customer){

        Customer existingCustomer = repository.findById(customer.getId()).orElse(null);
        existingCustomer.setFirstname(customer.getFirstname());
        existingCustomer.setLastname(customer.getLastname());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setPhonenumber(customer.getPhonenumber());



        return repository.save(existingCustomer);
    }
}
