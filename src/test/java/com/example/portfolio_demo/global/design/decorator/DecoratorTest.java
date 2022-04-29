package com.example.portfolio_demo.global.design.decorator;

import com.example.portfolio_demo.global.design.decorator.audimodel.A3;
import com.example.portfolio_demo.global.design.decorator.audimodel.A4;
import com.example.portfolio_demo.global.design.decorator.audimodel.A5;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DecoratorTest {

    @Test
    void audiTest(){
        ICar audi = new Audi(1000);
        audi.showPrice();

        // a3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();

        // a4
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();

        // a5
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice(); // 이렇게 기본 뼈대는 그대로 유지하면서 부가적인 첨가를 하면서 (등급이 올라갈때 마다 가격이 증가한다던지) 속성을 변환 시키는것을 데코레이터 패턴이라고 한다.
    }

}