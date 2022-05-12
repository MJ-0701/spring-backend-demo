package com.example.portfolio_demo;

import com.example.portfolio_demo.global.config.ApplicationContextProvider;
import com.example.portfolio_demo.global.utils.encode.Base64Encoder;
import com.example.portfolio_demo.global.utils.encode.Encoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PortfolioDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioDemoApplication.class, args);


    }

}
