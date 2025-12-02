package com.example.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class BasketBall implements Coach{
    @Override
    public String getDailyWorkout() {
        return "I'm Playing basketball";
    }
    public BasketBall(){
        System.out.println("Basketball coach constructor");
    }
}
