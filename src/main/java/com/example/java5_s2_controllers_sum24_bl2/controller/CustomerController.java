package com.example.java5_s2_controllers_sum24_bl2.controller;

import com.example.java5_s2_controllers_sum24_bl2.entity.Country;
import com.example.java5_s2_controllers_sum24_bl2.entity.Customer;
import com.example.java5_s2_controllers_sum24_bl2.service.CountryService;
import com.example.java5_s2_controllers_sum24_bl2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    final
    CustomerService customerService;

    final
    CountryService countryService;

    public CustomerController(CustomerService customerService, CountryService countryService) {
        this.customerService = customerService;
        this.countryService = countryService;
    }

    @ModelAttribute
    public void addAttributes(ModelMap model) {
        List<Country> countries = countryService.findAll();
        model.addAttribute("countries", countries);
    }

    @GetMapping("/customer")
    public String showCustomerForm(@ModelAttribute("customer") Customer customer, Model model) {

        return "customerForm";
    }

    @PostMapping("/customer")
    public String addCustomer(
            @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult,
            ModelMap model
    ) {

        if (bindingResult.hasErrors()) {
            return "customerForm";
        }

        customerService.addCustomer(customer);
        return "redirect:/employees"; //tam

    }



}
