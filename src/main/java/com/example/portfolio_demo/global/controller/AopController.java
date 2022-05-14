package com.example.portfolio_demo.global.controller;

import com.example.portfolio_demo.global.domain.request.UserDTO;
import com.example.portfolio_demo.global.utils.annotation.Decode;
import com.example.portfolio_demo.global.utils.annotation.Timer;
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

    @DeleteMapping("/delete")
    @Timer
    public void deleteMethod(){

        // db logic -> 1초 정도 걸린다고 가정
        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/put")
    @Decode
    public UserDTO putMethod(@RequestBody UserDTO userDTO){

        System.out.println("put");
        System.out.println(userDTO);

        return userDTO;
    }
}
