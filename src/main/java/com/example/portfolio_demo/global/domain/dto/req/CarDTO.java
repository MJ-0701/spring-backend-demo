package com.example.portfolio_demo.global.domain.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class CarDTO {

    private String name;

    @JsonProperty("car_number")
    private String carNumber;
}
