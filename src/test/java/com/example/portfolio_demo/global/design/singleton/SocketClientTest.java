package com.example.portfolio_demo.global.design.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SocketClientTest {

    @Test
    void singletonTest(){
        SingletonA singletonA = new SingletonA();
        SingletonB singletonB = new SingletonB();

        SocketClient aClient = singletonA.getSocketClient();
        SocketClient bClient = singletonB.getSocketClient();

        System.out.println("두개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient)); //true
    }

}