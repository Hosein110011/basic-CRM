package com.lu2code.cruddemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declaration
    @Pointcut("execution(* com.lu2code.cruddemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.lu2code.cruddemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.lu2code.cruddemo.dao.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {}


    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("======>> int @Before: calling method: " + theMethod);

        // display the arguments to the method

        // get the arguments
        Object[] args = theJoinPoint.getArgs();

        // loop thru and display args
        for (Object tempArg : args) {
            myLogger.info("======>> argument: " + tempArg);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("======>> in @AfterReturning: from method: " + theMethod);

        // display data returned
        myLogger.info("======>> result: " + theResult);
    }
}
