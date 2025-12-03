package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class BasketBall implements Coach{
    @Override
    public String getDailyWorkout() {
        return "I'm Playing basketball";
    }
}
