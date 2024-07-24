package com.example.java5_s2_controllers_sum24_bl2.service;

import com.example.java5_s2_controllers_sum24_bl2.entity.Employee;
import com.example.java5_s2_controllers_sum24_bl2.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    final
    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {

        return employeeRepository.getEmployees();
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee findById(Long id) {

        return employeeRepository.findById(id);
    }

    public void updateEmployee(@Valid Employee employee) {

        employeeRepository.updateEmployee(employee);
    }

    public void addEmployee(Employee employee) {

        employeeRepository.addEmployee(employee);
    }
}
