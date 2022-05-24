//package com.example.portfolio_demo.global.utils.aop;
//
//import com.example.portfolio_demo.global.domain.request.UserDTO;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Base64;
//
//@Aspect
//@Component
//public class DecodeAop {
//
//    @Pointcut("execution(* com.example.portfolio_demo.global.controller..*.*(..))")
//    private void cut(){
//
//    }
//
//    @Pointcut("@annotation(com.example.portfolio_demo.global.utils.annotation.Decode)")
//    private void decode(){
//
//    }
//
//    @Before("cut() && decode()")
//    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
//        Object[] args = joinPoint.getArgs();
//
//        for(Object arg : args){
//            if(arg instanceof UserDTO){
//                UserDTO userDTO = UserDTO.class.cast(arg);
//                String base64Email = userDTO.getEmail(); // 기존 base64로 encoding 돼 있엇다고 가정하고
//                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8"); // decoding
//                userDTO.setEmail(email); // decoding email을 set
//
//            }
//        }
//    }
//
//    @AfterReturning(value = "cut() && decode()", returning = "returnObj")
//    public void afterReturn(JoinPoint joinPoint, Object returnObj){
//
//        if(returnObj instanceof UserDTO){
//            UserDTO userDTO = UserDTO.class.cast(returnObj);
//            String email = userDTO.getEmail(); // 위랑 반대
//            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());
//            userDTO.setEmail(base64Email);
//        }
//
//    }
//
//
//}
