package com.example.aopDemo.aspect;

import com.example.aopDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import org.aspectj.lang.reflect.MethodSignature;

import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.List;

@Aspect
@Component
@Order(1)

public class MyDemoLoggingAspect {


    @Around(
          "execution( *  com.example.aopDemo.service.TrafficFortuneService.getFortune(..) )"
    )
    public Object aroundFortuneAdvice(
            ProceedingJoinPoint proceedingJoinPoint
    ) throws Throwable{

        String method = proceedingJoinPoint.getSignature().toString();
        System.out.println("The method is " + method);

        System.out.println("=============?============");

        System.out.println("We are starting count the time nowwww, @Arounddddddd ");

        // start time
        long start = System.currentTimeMillis();
        Object result = null ;
        try {
            // run the function which is the get fortune
             result = proceedingJoinPoint.proceed();
        }catch (Exception e){

            System.out.println("Around advice has Exception " + e.getMessage());

//            result = "Nothing to do, we have an exception ";
            // throw the exception instead of handle it
            throw e;
        }
        // end time
        long end = System.currentTimeMillis();


        long duration = end - start ;

        System.out.println("The duration is "+ duration / 1000.0 + " seconds ");

        return result  ;
    }



    @After( "execution( *  com.example.aopDemo.dao.AccountDAO.findAccounts(..) )" )
    // run for success or failure
    public void afterFindAccountAdvice(JoinPoint joinPoint){

        String method = joinPoint.getSignature().toString();
        System.out.println(" ===================> @After Finally Method <=================== \n"
                + method);
    }

    @AfterThrowing(
            pointcut = "execution( *  com.example.aopDemo.dao.AccountDAO.findAccounts(..) )",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint , Throwable theExc){

        String method = joinPoint.getSignature().toString();
        System.out.println(" ===================> @AfterThrowing Method <=================== \n"
                + method);

        System.out.println(" ===================> @AfterThrowing Exception <=================== \n"
                + theExc);


    }

    @AfterReturning(
            pointcut = "execution( *  com.example.aopDemo.dao.AccountDAO.findAccounts(..) )"  ,
            returning = "result"
    )
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint ,
                                                List<Account> result){

        String method = joinPoint.getSignature().toString();
        System.out.println("\n ===================> @AfterRetrning Method <=================== ");
        System.out.println(method);
        System.out.println("\n ===================> @AfterRetrning List <=================== ");
        System.out.println(result);

        // post process the data
        for(Account i : result){

            if(i.getName() == null){
                i.setName("Empty");
            }
            else{
                i.setName(i.getName().toUpperCase());
            }

        }

        System.out.println("After edit names ");
        System.out.println(result);


    }



    @Before("com.example.aopDemo.aspect.AOPExpression.combine()")
    public void beforeAddAccountAdvice(JoinPoint tjoinPoint) {

        System.out.println("\n ==============>>> Executing @Before device on addAccount <<<=======================");
        MethodSignature methodSignature = (MethodSignature) tjoinPoint.getSignature();
        System.out.println("Method:::   " + methodSignature);


        Object[] args = tjoinPoint.getArgs();

        for(Object c : args){
            System.out.println(c);


            if(c instanceof Account){
                System.out.println("i'm an AAAAAAacount");

                Account d = (Account) c;

                System.out.println("Account name: " + d.getName() + " ,Account Level: " + d.getLevel());
            }
        }

    }
}
