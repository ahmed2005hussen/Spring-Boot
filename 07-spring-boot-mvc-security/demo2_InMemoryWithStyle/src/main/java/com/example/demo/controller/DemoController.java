package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {


    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "showMyLoginPage";
    }

    @GetMapping("/leaders")
    public String leaders() {
        return "leaders";
    }

    @GetMapping("/systems")
    public String systems() {
        return "systems";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

}
