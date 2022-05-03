package com.example.portfolio_demo.global.controller;

import com.example.portfolio_demo.global.domain.dto.req.UserRequestDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ControllerTest {

    // Object Mapper
    @Test
    void test() throws JsonProcessingException {
        System.out.println("Test");

        // Object Mapper : Text JSON -> Object
        // Object -> Text JSON
        // controller req json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();

        // object -> text : object mapper 가 get method를 활용한다.
        var userRequest = new UserRequestDTO("jack", 32, "010-1111-2222");
        var text = objectMapper.writeValueAsString(userRequest);
        System.out.println(text);

        // text -> object : object mapper 는 동작하기 위해서 default 생성자가 존재 해야됨.
        var objectUser = objectMapper.readValue(text, UserRequestDTO.class);
        System.out.println(objectUser);

    }

}