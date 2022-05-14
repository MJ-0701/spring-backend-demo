package com.example.portfolio_demo.global.utils.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component // @Bean 과 @Component 의 차이는 bean은 class에 붙일수 없다.
public class TimerAop {

    @Pointcut("execution(* com.example.portfolio_demo.global.controller..*.*(..))")
    private void cut(){

    }

    @Pointcut("@annotation(com.example.portfolio_demo.global.utils.annotation.Timer)")
    private void enableTimer(){

    }


    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();

        stopWatch.stop();

        System.out.println("result :" + result);
        System.out.println("Total Time :" + stopWatch.getTotalTimeSeconds());


    }

}
