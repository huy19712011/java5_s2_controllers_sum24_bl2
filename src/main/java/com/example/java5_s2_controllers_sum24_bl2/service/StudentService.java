package com.example.java5_s2_controllers_sum24_bl2.service;

import com.example.java5_s2_controllers_sum24_bl2.entity.Student;
import com.example.java5_s2_controllers_sum24_bl2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    final
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {

        return studentRepository.getStudents();
    }
}
