package com.example.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // create a global pointcut

    @Pointcut("execution( *  com.example.aopDemo.dao.*.*(..))")
    public void pointCutGlobalPoint(){}

    // pointcut

    @Before("pointCutGlobalPoint()")

    public void beforeAddAccountAdvice() {

        System.out.println("\n ==============>>> Executing @Before device on addAccount <<<=======================");
    }

    @Before("pointCutGlobalPoint()")
    public void ApiAnalytics() {

        System.out.println("\n ==============>>> API Analytics <<<=======================");
    }

}
