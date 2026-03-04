package com.example.aopDemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AOPExpression {

    // create a global pointcut

    @Pointcut("execution( *  com.example.aopDemo.dao.*.*(..))")
    public void pointCutGlobalPoint(){}

    // create pointcut for getter
    @Pointcut("execution( * com.example.aopDemo.dao.*.get*(..))")
    public void getter(){}

    // create pointcut for setter
    @Pointcut("execution( * com.example.aopDemo.dao.*.set*(..))")
    public void setter(){}

    // create pointcut include package exclude getters and setters
    @Pointcut("pointCutGlobalPoint() && !(setter() || getter())")
    public void combine(){}

}
