package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;

    // we have a lot of component this will confuse for @AutoWired to find the Dependency to inject it
    // by using @Qualifier(), we said that: we want to choose football bean
    @Autowired
    public DemoController(@Qualifier("tennis")Coach coach) {// name of class first character small
        this.coach = coach;
    }

    @GetMapping("/coach")
    public String callCoach() {
       return coach.getDailyWorkout();
    }

}

