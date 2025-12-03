package com.example.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Tennis implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Playing tennis";
    }
    public Tennis() {
        System.out.println("Tennis constructor");
    }
}
