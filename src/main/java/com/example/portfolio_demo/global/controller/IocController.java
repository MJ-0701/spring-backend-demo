package com.example.portfolio_demo.global.controller;

import com.example.portfolio_demo.global.utils.encode.Base64Encoder;
import com.example.portfolio_demo.global.utils.encode.Encoder;
import com.example.portfolio_demo.global.utils.encode.IEncoder;
import com.example.portfolio_demo.global.utils.encode.UrlEncoder;

public class IocController {

    public void encoding(){

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // Base 64 encoding
        IEncoder base64Encoder = new Base64Encoder();
        String result = base64Encoder.encode(url);
        //System.out.println(result);

        // Url Encoding
        IEncoder urlEncoder = new UrlEncoder();
        String urlEncoding = urlEncoder.encode(url);
        //System.out.println(urlEncoding);

        // DI 적용 후 코드 변화
        Encoder encoder = new Encoder(new UrlEncoder()); // 이런식으로 외부에서 사용하는 객체를 주입 받는 방식이 DI
        System.out.println(encoder.encode(url));



    }
}
