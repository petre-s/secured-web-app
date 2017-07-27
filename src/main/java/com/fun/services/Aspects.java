package com.fun.services;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by pstanaringa on 26.07.2017.
 */
@Aspect
//@Component
public class Aspects {
    @Before("execution(* com.fun.db.UserRepository.*(..))")
    public void advice(JoinPoint joinPoint){
        System.out.print("");
    }
}
