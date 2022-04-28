package com.example.portfolio_demo.global.design.proxy;

import com.example.portfolio_demo.global.design.aop.AopBrowser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BrowserTest {

    @Test
    void proxyTest(){
//        Browser browser = new Browser("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show(); // 캐시기능이 없을경우 한번씩 계속 호출됨.

//        IBrowser browser = new BrowserProxy("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show(); // 처음에만 로딩을하고 나머지는 캐싱된 결과를 가져옴.

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
            long now = System.currentTimeMillis();
            end.set(now - start.get());
                }
        );
        aopBrowser.show();
        System.out.println("loading time" + end.get()); // 첫 로딩시 1.5초

        aopBrowser.show();
        System.out.println("loading time" + end.get()); // 두번째 로딩은 캐시를 이용하기때문에 0초

        // 이런식으로 aop 패턴은 프록시 패턴을 활용하고 있고 특정한 메소드라던지 특정한 기능에 앞뒤로 내가 원하는 기능 또는 앞뒤로 넘어가는 아규먼트에 대해 조작도 할수 있고
        // 흩어져있는 공통된 기능들을 하나로 묶어줄수 있다.

    }

}