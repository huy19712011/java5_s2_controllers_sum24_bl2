package com.example.java5_s2_controllers_sum24_bl2.repository;

import com.example.java5_s2_controllers_sum24_bl2.entity.Employee;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
