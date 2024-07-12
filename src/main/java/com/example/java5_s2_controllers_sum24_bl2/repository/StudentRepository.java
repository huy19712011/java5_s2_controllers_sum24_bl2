package com.example.java5_s2_controllers_sum24_bl2.repository;

import com.example.java5_s2_controllers_sum24_bl2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    // fix data
    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1, "student 1", "student1@gmail.com"));
        students.add(new Student(2, "student 2", "student2@gmail.com"));
        students.add(new Student(3, "student 3", "student3@gmail.com"));
    }

    // Lay data tu database
    public List<Student> getStudents() {
        return students;
    }
}
