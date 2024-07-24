package com.example.java5_s2_controllers_sum24_bl2.controller;

import com.example.java5_s2_controllers_sum24_bl2.entity.Employee;
import com.example.java5_s2_controllers_sum24_bl2.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Controller
public class EmployeeController {

    final
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public String showForm(@ModelAttribute("employee") Employee employee/*, Model model*/) {

        // model.addAttribute("employee", new Employee());
        return "employeeHome";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult bindingResult,
            ModelMap model
    ) {

        if (bindingResult.hasErrors()) {
            return "employeeHome";
        }

        //model.addAttribute("name", employee.getName());
        //model.addAttribute("contactNumber", employee.getContactNumber());
        //model.addAttribute("office", employee.getOffice());
        //model.addAttribute("id", employee.getId());

        employeeService.addEmployee(employee);

        return "employeeView";
    }

    // "/employees"
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String showEmployees(ModelMap modelMap) {
        // ...
        modelMap.addAttribute("employees", employeeService.getEmployees());
        return "employeeList";
    }

    @RequestMapping(value = "/employees-delete", method = RequestMethod.GET)
    public String removeEmployee(ModelMap modelMap, @RequestParam("id") Long id) {

        // service -> remove

        employeeService.deleteById(id);

        //ArrayList<Employee> list = employeeService.getEmployees().stream()
        //        .filter(employee -> employee.getId() != id)
        //        .collect(Collectors.toCollection(ArrayList::new));
        //modelMap.addAttribute("employees", list);

        return "redirect:employees";
    }

    @RequestMapping(value = "/employees-update", method = RequestMethod.GET)
    public String showEmployeeFormToUpdate(@RequestParam("id") Long id, ModelMap modelMap) {

        Employee employee = employeeService.findById(id);
        modelMap.addAttribute("employee", employee);

        return "employeeHome";
    }

    @RequestMapping(value = "/employees-update", method = RequestMethod.POST)
    public String updateEmployee(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult bindingResult,
            ModelMap modelMap) {

        if (bindingResult.hasErrors())
            return "employeeHome";

        employeeService.updateEmployee(employee);
        return "redirect:employees";
    }



}

