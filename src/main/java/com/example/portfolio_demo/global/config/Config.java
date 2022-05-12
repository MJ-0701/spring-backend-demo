package com.example.portfolio_demo.global.config;

import com.example.portfolio_demo.global.utils.encode.Base64Encoder;
import com.example.portfolio_demo.global.utils.encode.Encoder;
import com.example.portfolio_demo.global.utils.encode.UrlEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 하나의 클래스에서 여러개의 빈을 등록할때 사용
public class Config {

    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder){

        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder){

        return new Encoder(urlEncoder);
    }
}
