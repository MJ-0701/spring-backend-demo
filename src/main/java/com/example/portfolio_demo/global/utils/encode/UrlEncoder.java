package com.example.portfolio_demo.global.utils.encode;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Component // 컴포넌트 어노테이션은 스프링이 실행이 될떄 해당 어노테이션을 찾아서 직접 객체를 싱글톤 형태로 만들어서 스프링 컨테이너에서 관리를 하게됨.
public class UrlEncoder implements IEncoder{

    public String encode(String msg){
        try {
            return URLEncoder.encode(msg,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);

        }
    }
}
