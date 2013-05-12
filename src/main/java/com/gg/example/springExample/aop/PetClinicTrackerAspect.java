package com.gg.example.springExample.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * User: adurmaz
 * Date: 5/12/13
 * Time: 1:44 PM
 */
@Aspect
public class PetClinicTrackerAspect {

    //@Around("execution(* com.gg.example.springExample..*.*(..))")
    @Around("bean(*Service)")
    public Object trace(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        try {
            System.out.println("Before : " + proceedingJoinPoint.getSignature());
            return proceedingJoinPoint.proceed();
        } finally {
            System.out.println("After :" + proceedingJoinPoint.getSignature());
        }
    }
}
