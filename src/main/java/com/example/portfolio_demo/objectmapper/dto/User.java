package com.example.portfolio_demo.objectmapper.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class User {

    private String name;
    private int age;
    private List<Car> carList;

}
