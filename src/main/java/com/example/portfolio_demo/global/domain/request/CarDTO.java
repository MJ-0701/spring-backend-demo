package com.example.portfolio_demo.global.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class CarDTO {

    @NotBlank
    private String name;

    @NotBlank
    @JsonProperty("car_number")
    private String carNumber;

    @JsonProperty("TYPE")
    private String type;
}
