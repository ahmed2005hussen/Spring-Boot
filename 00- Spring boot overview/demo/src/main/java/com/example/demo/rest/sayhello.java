package com.example.demo.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sayhello {

@Value("${coach.name}")
private String coachName ;

@Value("${team.name}")
private String teamName ;


    @GetMapping("/")
    String sayhello() {
        return coachName;
    }


    @GetMapping("/workout")
    String workout() {
        return "runnn ";
    }

    @GetMapping("/hi")
    String hi() {
        return "hi";
    }
}
