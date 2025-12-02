package com.example.demo.config;

import com.example.demo.Coach;
import com.example.demo.FootBallCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Play {

    @Bean("football")
    // اسم الكلام بيكون هو ال bean id او لو قولنا
    // @Bean(" حاجه ")
    // ساعتها الحاجه دي بتكون هي ال bean id اللي بنكتبه في ال Qualifier@
    public Coach he() {
        return new FootBallCoach();
    }
}
