package com.example.portfolio_demo.global.config;

import com.example.portfolio_demo.global.utils.encode.Base64Encoder;
import com.example.portfolio_demo.global.utils.encode.Encoder;
import com.example.portfolio_demo.global.utils.encode.UrlEncoder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationContextProviderTest {

    @Test
    void applicationProviderTest(){

        ApplicationContext context = ApplicationContextProvider.getContext();

//        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        Encoder encoder = context.getBean("urlEncode",Encoder.class);


        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
        String result = encoder.encode(url);
        System.out.println(result);



    }


}