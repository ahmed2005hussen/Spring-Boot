package com.example.aopDemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneImp implements TrafficFortuneService{
    @Override
    public String getFortune() {
        return getFortune(false);
    }

    @Override
    public String getFortune(boolean isException) {

        // simulate a delay

        try {

            if(isException){
                throw new RuntimeException();
            }

            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return "Except heavy traffic this morning ";
    }
}
