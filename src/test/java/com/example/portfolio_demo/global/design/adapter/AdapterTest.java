package com.example.portfolio_demo.global.design.adapter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdapterTest {

    // 콘센트 역할할
   public void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }

    @Test
    void adapterTest(){
        HairDryer110V hairDryer110V = new HairDryer110V();
        connect(hairDryer110V); // 헤어 드라이기 110v on

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new Adapter(cleaner);
        connect(adapter); // 청소기 220v on
    }

}