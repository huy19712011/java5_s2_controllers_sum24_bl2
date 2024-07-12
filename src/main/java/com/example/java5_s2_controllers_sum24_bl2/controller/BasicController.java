package com.example.java5_s2_controllers_sum24_bl2.controller;

import com.example.java5_s2_controllers_sum24_bl2.entity.Student;
import com.example.java5_s2_controllers_sum24_bl2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
//@RestController
public class BasicController {

    //@GetMapping(value = "/hello")
    //public String hello() {
    //    return "home";
    //}

    final
    StudentService  studentService;

    public BasicController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String showStudents(Model model) {

        List<Student> students = studentService.getStudents();

        model.addAttribute("students", students);

        return "home";
    }

}
