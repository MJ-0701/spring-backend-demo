package com.example.portfolio_demo.objectmapper;

import com.example.portfolio_demo.objectmapper.dto.Car;
import com.example.portfolio_demo.objectmapper.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObjectMapperTest {

    @Test
    void objectMapperTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(); // 라이브러리임.

        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("k5");
        car1.setCarNumber("11가 1111");
        car1.setType("세단");

        Car car2 = new Car();
        car2.setName("x1");
        car2.setCarNumber("12가 2211");
        car2.setType("세단");

        List<Car> carList = Arrays.asList(car1, car2);
        user.setCarList(carList);

//        System.out.println(user);

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();
        System.out.println("name :" + _name);
        System.out.println("age :" + _age);

//        List<Car> _carList = jsonNode.get("carList").asText(); 배열은 이런식으로 가져올수 없다.
        JsonNode arrayCarList = jsonNode.get("carList");
        ArrayNode arrayNode = (ArrayNode) arrayCarList;
        List<Car> _carList = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});
        System.out.println(_carList);

        // JsonNode 클래스에서는 Json 데이터의 변경을 막아 놨기 때문에 변경 하려면 다른 클래스를 사용한다.
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "mj");
        objectNode.put("age", 20);
        System.out.println(objectNode.toPrettyString()); // Json을 이쁘게 출력한단 의미로 pretty


    }


}