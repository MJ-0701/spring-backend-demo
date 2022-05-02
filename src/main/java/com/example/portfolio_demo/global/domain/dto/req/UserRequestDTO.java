package com.example.portfolio_demo.global.domain.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
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
}
