package com.example.java5_s2_controllers_sum24_bl2.controller;

import com.example.java5_s2_controllers_sum24_bl2.entity.Employee;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

    @GetMapping("/employee")
    public String showForm(@ModelAttribute("employee") Employee employee/*, Model model*/) {

        // model.addAttribute("employee", new Employee());
        return "employeeHome";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult bindingResult,
            ModelMap model
    ) {

        if (bindingResult.hasErrors()) {
            return "employeeHome";
        }

        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("office", employee.getOffice());
        model.addAttribute("id", employee.getId());

        return "employeeView";
    }
}
