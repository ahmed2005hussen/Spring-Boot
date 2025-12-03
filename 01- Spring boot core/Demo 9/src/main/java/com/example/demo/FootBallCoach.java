package com.example.demo;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component

public class FootBallCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "I'm Playing football";
    }

    @PostConstruct
    public void init(){
        System.out.println("BasketBallCoach init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("BasketBallCoach destroy");
    }
}
