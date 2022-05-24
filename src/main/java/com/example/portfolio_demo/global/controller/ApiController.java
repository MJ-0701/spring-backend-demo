package com.example.portfolio_demo.global.controller;

import com.example.portfolio_demo.global.domain.request.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class ApiController {

//    @PostMapping("/user")
//    public ResponseEntity user(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult){ // @Valid 가 붙은 객체는 해당 객체에 어노테이션을 검사하고 거기에 대한 값들을 검증하게 되서
//        // 맞지 않은 값들이 있을경우 에러 발생
//
//        // @BindingResult 는 Valid에 대한 결과가 바로 나타나는것이 아니라 bindresult에 담아준다.
//        if(bindingResult.hasErrors()){
//            StringBuilder sb = new StringBuilder();
//            bindingResult.getAllErrors().forEach(objectError -> {
//                FieldError field = (FieldError) objectError;
//                String msg = objectError.getDefaultMessage();
//
//                System.out.println("field : " + field.getField());
//                System.out.println("msg :" + msg);
//
//                sb.append("field : " + field.getField());
//                sb.append("msg :" + msg);
//            });
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
//        }
//        System.out.println(userDTO);
//
//        return ResponseEntity.ok(userDTO);
//    }

    @GetMapping("")
    public UserDTO get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        userDTO.setAge(age);
        int a = 10 + age;

        return userDTO;

    }

    @PostMapping("")
    public UserDTO post(@Valid @RequestBody UserDTO userDTO){
        System.out.println(userDTO);

        return userDTO;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e){
        System.out.println("api controller"); // 컨트롤러가 우선순위 인것을 확인.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }
}
