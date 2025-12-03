package com.example.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary // we have no more one Primary annotation
@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Hello i'm Ahmed";
    }

    public CricketCoach(){
        System.out.println("Cricket coach constructor");
    }
}
