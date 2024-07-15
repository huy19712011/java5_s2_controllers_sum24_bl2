package com.example.java5_s2_controllers_sum24_bl2.controller;

import com.example.java5_s2_controllers_sum24_bl2.entity.Student;
import com.example.java5_s2_controllers_sum24_bl2.service.StudentService;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    // 2. @RequestParam
    // http://localhost:8080/hello?name=Poly&email=...

    //@GetMapping(value = "/hello")
    //@ResponseBody
    //public String sayHello(
    //        @RequestParam(name = "username") @Nullable String name,
    //        @RequestParam(name = "myemail", required = false) String email
    //) {
    //    return "Hello " + name + " --- " + email;
    //}

    // Optional<T>
    // default value
    @GetMapping(value = "/hello")
    @ResponseBody
    public String sayHello(
            @RequestParam(name = "username") Optional<String> name,
            @RequestParam(name = "myemail", defaultValue = "DefaultEmail") String email
    ) {
        return "Hello " + name.orElseGet(() -> "Not Provided") + " --- " + email;
    }

    //@PathVariable
    // http://localhost:8080/hello/1
    @GetMapping(value = "/hello/{id}/{email}")
    @ResponseBody
    public String sayHelloV2(
            @PathVariable("id") int id,
            @PathVariable("email") String email
    ) {

        return "Student with id = " + id + " email = " + email;
    }

    //headers
    //@RequestMapping(value = "/method", headers="key1=value1")
    //@ResponseBody
    //public String method() {
    //    return "method";
    //}

    // cookie
    // reading
    @RequestMapping("/readCookie")
    @ResponseBody
    public  String readCookieValue(
            @CookieValue(value = "username", defaultValue = "default") String username) {

        return "Cookie value: " + username;
    }

    // set cookie
    @GetMapping("/change-username")
    @ResponseBody
    public String setCookie(HttpServletResponse response) {
        // create cookie
        Cookie cookie = new Cookie("username", "NewName");

        // add
        response.addCookie(cookie);
        return "Username changed";
    }

    // read all cookies
    @GetMapping("/all-cookies")
    @ResponseBody
    public String readAllCookies(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return Arrays.stream(cookies)
                    .map(c -> c.getName() + " = " + c.getValue())
                    .collect(Collectors.joining(", "));
        }

        return  "No cookies";
    }


}

