package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// that's mean this class will be injected by default if no Qualifier exists.
@Primary
@Component
public class FootBallCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "I'm Playing football";
    }
}
