package com.example.portfolio_demo.global.controller;

import com.example.portfolio_demo.global.domain.request.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AopController {

    @GetMapping("/get/{id}")
    public String getMethod(@PathVariable Long id, @RequestParam String name){

//        System.out.println("get id :" + id + ", name :" + name); // pointcut을 사용하여 외부에서 바라볼수 있기 떄문에 더 이상 사용할 필요가 없음

        return "id :" + id + "name :" + name;

    }

    @PostMapping("/post")
    public UserDTO postMethod(@RequestBody UserDTO userDTO){
//        System.out.println("user info :" + userDTO); // pointcut을 사용하여 외부에서 바라볼수 있기 떄문에 더 이상 사용할 필요가 없음
        return userDTO;
    }
}
