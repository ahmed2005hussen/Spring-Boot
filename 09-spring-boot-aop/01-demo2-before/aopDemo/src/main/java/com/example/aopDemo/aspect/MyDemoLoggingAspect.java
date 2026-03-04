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
    private void pointCutGlobalPoint(){}

    // create pointcut for getter
   @Pointcut("execution( * com.example.aopDemo.dao.*.get*(..))")
   private void getter(){}

    // create pointcut for setter
    @Pointcut("execution( * com.example.aopDemo.dao.*.set*(..))")
   private void setter(){}


    // create pointcut include package exclude getters and setters
    @Pointcut("pointCutGlobalPoint() && !(setter() || getter())")
    private void combine(){}

//    @Before("pointCutGlobalPoint()")
    @Before("combine()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n ==============>>> Executing @Before device on addAccount <<<=======================");
    }

//   @Before("pointCutGlobalPoint()")
    @Before("combine()")
   public void ApiAnalytics() {

       System.out.println("\n ==============>>> API Analytics <<<=======================");
   }




}
