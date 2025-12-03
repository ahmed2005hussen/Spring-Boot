package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "I'm Playing football";
    }

    public FootBallCoach() {
        System.out.println("Football coach constructor");
    }
}
