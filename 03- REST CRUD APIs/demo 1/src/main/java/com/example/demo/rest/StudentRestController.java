package com.example.demo.rest;


import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students ;

    @PostConstruct
    public void loadStudents() {
        students = new ArrayList<>();
        Student student = new Student("ahmed", "hussein");
        Student student1 = new Student("Abdo", "hussein");
        Student student2 = new Student("saleh", "hussein");
        students.add(student);
        students.add(student1);
        students.add(student2);
    }
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }


    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID) {

        if(studentID < 0 || studentID >= students.size()){
            throw new studentNotFoundException("student id not found - "+ studentID);
        }
        return students.get(studentID);
    }
}
