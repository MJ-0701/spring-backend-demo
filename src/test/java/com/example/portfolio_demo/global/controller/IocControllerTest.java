package com.example.portfolio_demo.global.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IocControllerTest {

    @Test
    void encodingTest(){
        IocController ioc = new IocController();

        ioc.encoding();
    }

}