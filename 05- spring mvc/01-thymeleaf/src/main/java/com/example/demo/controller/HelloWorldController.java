package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }


    @RequestMapping("/processForm")
    public String processForm(
            @RequestParam("studentName") String name, Model model){
        model.addAttribute("theName" ,name);
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        String name = request.getParameter("studentName");
        name = name.toUpperCase();
        String result = "Yo! " + name;
        model.addAttribute("theName" ,result);

        return "helloworld";
    }
}
