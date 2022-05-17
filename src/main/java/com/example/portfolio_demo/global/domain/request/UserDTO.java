package com.example.portfolio_demo.global.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class UserDTO {

//    private Long id;

    private String name;

    private String pwd;

    @Email
    private String email;

    @JsonProperty("phone_number")
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다.") // 핸드폰 정규식
    private String phoneNumber;
}
