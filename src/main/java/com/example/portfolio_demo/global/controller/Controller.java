package com.example.portfolio_demo.global.controller;

import com.example.portfolio_demo.global.domain.dto.req.UserRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api") // URI 를 지정해주는 Annotation
@RestController // 해당 Class 는 REST API 를 처리하는 Controller
public class Controller {

    @GetMapping("/hello")
    public String hello(){
        return "test"; // 성공
    }

    @GetMapping("/get/path-variable/{name}") // http://localhost:8080/api/get/path-variable/{name}
    public String pathVariable(@PathVariable(name = "name") String pathName){ // 기본적으로 파라미터와 경로변수의 이름은 같아야 함. 하지만 어쩔수 없는 경우 따로 (name = "name") 으로 맞춰 줄 수 있음
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    @GetMapping("/get/query-param") // http://localhost:8080/api/get/query-param?user=jack&email=jack2718@naver.com&age=32
    public String queryParameter(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");
            sb.append(entry.getKey() + "=" + entry.getValue()+ "\n");
        });
        return sb.toString();
    }

    @GetMapping("/get/query-param02")
    public String queryParam(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam int age){

        return name+ " " + email + " " +age;
    }


    @GetMapping("/get/query-param03")
    public String queryParam03(UserRequestDTO userRequestDTO){ // 실제 현업에서 사용하는 방법.
        System.out.println(userRequestDTO.getName());
        System.out.println(userRequestDTO.getEmail());
        System.out.println(userRequestDTO.getAge());

        return userRequestDTO.toString(); // UserRequestDTO(name=채명정, email=jack2718@naver.com, age=32)
    }



}
