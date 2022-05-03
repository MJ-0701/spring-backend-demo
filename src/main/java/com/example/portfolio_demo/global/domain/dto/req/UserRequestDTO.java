package com.example.portfolio_demo.global.domain.dto.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class) // 클래스단위로 설정 가능
@JsonInclude(JsonInclude.Include.NON_NULL) // Null 값 제외
public class UserRequestDTO {

    private String account;

    private String address;

    private String password;

    private String name;

    private String email;

    private int age;

    @JsonProperty("phone_number") // JSON 에서 snake_case 로 받아오게 되면 매칭이 안되므로 지정을 해줘야됨.
    private String phoneNumber;

    @JsonProperty("OTP")
    private String OTP;

    /*
{
    "car_list" : [
            {
                "name" : "",
                "car_number" : ""
            },
            {
                "name" : "",
                "car_number" : ""
            }

       ]
}


    */

    private List<CarDTO> carList;




}
