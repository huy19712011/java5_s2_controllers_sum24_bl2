package com.example.java5_s2_controllers_sum24_bl2.repository;

import com.example.java5_s2_controllers_sum24_bl2.entity.Employee;
import jakarta.validation.Valid;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    // fix data
    private static List<Employee> employees = new ArrayList<Employee>();
    static {
        employees.add(new Employee(1L, "employee1", "contactnumber 1", "office1"));
        employees.add(new Employee(2L, "employee2", "contactnumber 2", "office2"));
        employees.add(new Employee(3L, "employee3", "contactnumber 3", "office3"));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee findById(Long id) {

        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst().orElse(null);
    }

    public void deleteById(Long id) {

        employees.remove(findById(id));
    }

    public void updateEmployee(@Valid Employee employee) {

        employees.set(employees.indexOf(findById(employee.getId())), employee);

        //employees = employees.stream()
        //        .map(e -> e.getId() != employee.getId() ? e : employee)
        //        .collect(Collectors.toList());
    }

    public void addEmployee(Employee employee) {

        employees.add(employee);
    }
}
