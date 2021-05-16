package com.springtests.mvc.springmvctest.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
private static  final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.springtests.mvc.springmvctest.controller.AlienController.*(..)) && args(..)\"")
    public void logBefore(JoinPoint joinPoint){
        LOGGER.info("Starting method from aspect, method name:"+joinPoint.getSignature().getName());
    }

    @After("execution(* com.springtests.mvc.springmvctest.controller.AlienController.*(..)) && args(..)\"")
    public void logAfter(JoinPoint joinPoint){
        LOGGER.info("Ending method from aspect, method name:"+joinPoint.getSignature().getName());
    }
}
