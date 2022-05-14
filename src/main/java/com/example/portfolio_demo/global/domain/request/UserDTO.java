package com.example.portfolio_demo.global.domain.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {

    private Long id;

    private String name;

    private String pwd;

    private String email;
}
