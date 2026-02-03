package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class studentController {

    @GetMapping("/studentShowForm")
    public String showForm(Model model){

        Student student = new Student();
        model.addAttribute("student",student);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student")  Student student ){

        System.out.println(student.getFirstName() + " , " + student.getLastName());
        return "student-confirmation";
    }

}
