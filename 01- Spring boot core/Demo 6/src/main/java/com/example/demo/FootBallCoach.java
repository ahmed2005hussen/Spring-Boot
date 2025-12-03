package com.example.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@Lazy
public class FootBallCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "I'm Playing football";
    }

    public FootBallCoach() {
        System.out.println("Football coach constructor");
    }
}
