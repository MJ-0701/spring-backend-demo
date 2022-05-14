package com.example.portfolio_demo.global.utils.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.example.portfolio_demo.global.controller..*.*(..))") // 여러가지 수식들이 있으므로 복잡한 조건일 경우 찾아서 적용해 볼것.
    private void cut(){

    }

    @Before("cut()") // cut 메소드가 실행되기전에 실행
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature(); // 메소드 이름을 출력할수 있음
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs();
        for (Object obj : args){
            System.out.println("type :" + obj.getClass().getSimpleName());
            System.out.println("value :" + obj);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj") // cut 메소드가 실행된 후에 리턴값
    public void afterReturn(JoinPoint joinPoint, Object returnObj){

        System.out.println("returnObj");
        System.out.println(returnObj);
    }
}
