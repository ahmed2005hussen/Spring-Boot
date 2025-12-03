package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;
    private Coach Mycoach;

    @Autowired
    public DemoController(@Qualifier("footBallCoach")Coach coach ,
                          @Qualifier("footBallCoach")Coach Mycoach) {
        this.coach = coach;
        this.Mycoach = Mycoach;
    }

    @GetMapping("/coach")
    public String callCoach() {
        // the result is NO, that's mean coach and Mycoach is not the same object

       return coach == Mycoach?"Yes":"No";
    }

}

