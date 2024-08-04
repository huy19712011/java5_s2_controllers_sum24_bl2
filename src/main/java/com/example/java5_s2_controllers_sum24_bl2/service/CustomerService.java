package com.example.java5_s2_controllers_sum24_bl2.service;

import com.example.java5_s2_controllers_sum24_bl2.entity.Customer;
import com.example.java5_s2_controllers_sum24_bl2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    final
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {

        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) {

        customerRepository.save(customer);
    }
}

