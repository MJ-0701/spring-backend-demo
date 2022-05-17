package com.example.portfolio_demo.global.controller;

import com.example.portfolio_demo.global.domain.request.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult){ // @Valid 가 붙은 객체는 해당 객체에 어노테이션을 검사하고 거기에 대한 값들을 검증하게 되서
        // 맞지 않은 값들이 있을경우 에러 발생

        // @BindingResult 는 Valid에 대한 결과가 바로 나타나는것이 아니라 bindresult에 담아준다.
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String msg = objectError.getDefaultMessage();

                System.out.println("field : " + field.getField());
                System.out.println("msg :" + msg);

                sb.append("field : " + field.getField());
                sb.append("msg :" + msg);
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }
        System.out.println(userDTO);

        return ResponseEntity.ok(userDTO);
    }
}
