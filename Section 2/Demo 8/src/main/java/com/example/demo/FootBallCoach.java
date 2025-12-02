package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FootBallCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "I'm Playing football";
    }

    public FootBallCoach() {
        System.out.println("Football coach constructor");
    }
}
