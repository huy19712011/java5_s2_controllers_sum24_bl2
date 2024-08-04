package com.example.java5_s2_controllers_sum24_bl2.repository;

import com.example.java5_s2_controllers_sum24_bl2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
