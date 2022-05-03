package com.example.portfolio_demo.global.controller;

import com.example.portfolio_demo.global.domain.dto.req.UserRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {

    @RequestMapping("/index")
    public String index(){

        return "index.html";
    }

    // ResponseEntity

    // ResponseBody
    @ResponseBody
    @GetMapping("/user")
    public UserRequestDTO userRequest(){ // 실제로 이런식으로 사용하진 않음 알고만 있을것.
        var userRequestDTO = new UserRequestDTO(); // 자바 11버전 타입추론

        userRequestDTO.setName("jack");
        userRequestDTO.setAddress("서울 특별시");
        return  userRequestDTO;

    }
}
