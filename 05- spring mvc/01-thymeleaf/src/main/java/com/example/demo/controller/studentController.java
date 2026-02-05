package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class studentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${Languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/studentShowForm")
    public String showForm(Model model){

        Student student = new Student();
        model.addAttribute("student",student);

        model.addAttribute("countries",countries);

        model.addAttribute("languages",languages);

        model.addAttribute("systems",systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student")  Student student ){

        System.out.println(student.getFirstName() + " , " + student.getLastName() + " " + student.getCountry() + " " + student.getFavoriteLanguage());
        return "student-confirmation";
    }

}
