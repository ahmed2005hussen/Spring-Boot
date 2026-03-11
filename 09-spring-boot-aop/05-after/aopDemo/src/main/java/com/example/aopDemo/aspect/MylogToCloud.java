package com.example.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(3)
public class MylogToCloud {


    @Before("com.example.aopDemo.aspect.AOPExpression.combine()")
    public void logToCloud() {

        System.out.println("\n ==============>>> Log To Cloud  <<<=======================");
    }


}
