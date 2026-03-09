package com.example.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyAPIAnalytics {


    //   @Before("pointCutGlobalPoint()")
    @Before("com.example.aopDemo.aspect.AOPExpression.combine()")
    public void ApiAnalytics() {
        System.out.println("\n ==============>>> API Analytics <<<=======================");
    }

}
