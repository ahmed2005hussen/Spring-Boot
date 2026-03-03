package com.example.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // pointcut

//    @Before("execution(public void addAccount())") // for any method have the name 'addAccount'
//    @Before("execution(public void com.example.aopDemo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*())") // wildCard for any function start with add
//    @Before("execution( *  add*())") // modifier is optional, the first (*) for any return type
//    @Before("execution( *  add*(com.example.aopDemo.Account))") // with one parameter which is Account
//    @Before("execution( *  add*(com.example.aopDemo.Account, ..))") // .. mean more 0 or many parameters
//    @Before("execution( *  add*(..))") // .. mean more 0 or many parameters
    @Before("execution( *  com.example.aopDemo.dao.*.*(..))") // for any class in our package so first * for class , second for method

    public void beforeAddAccountAdvice() {

        System.out.println("\n ==============>>> Executing @Before device on addAccount <<<=======================");
    }

}
