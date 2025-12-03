package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;

    @Autowired
    DemoController(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/coach")
    public String callCoach() {
       return coach.getDailyWorkout();
    }

}

