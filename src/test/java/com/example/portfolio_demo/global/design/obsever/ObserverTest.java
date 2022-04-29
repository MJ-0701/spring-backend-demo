package com.example.portfolio_demo.global.design.obsever;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ObserverTest {

    @Test
    void observerTest(){
        Button button = new Button("버튼");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("메세지 전달 : click1"); // 이론상으로 버튼의 클릭이 일어나면 클릭의 메세지가 이벤트로 전달되어 시스템에 출력이 됨.
        button.click("메세지 전달 : click2");
        button.click("메세지 전달 : click3");
        button.click("메세지 전달 : click4"); // 이렇게 리스너를 통해서 옵저버 패턴은 특정한 이벤트 (버튼에대한 클릭)이 일어났을때 해당 메세지를 리스너를 통해서 이벤트를 전달해주는 이러한 패턴을 옵저버 패턴이라고 한다.
    }
}