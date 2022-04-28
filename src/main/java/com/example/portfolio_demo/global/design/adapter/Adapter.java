package com.example.portfolio_demo.global.design.adapter;


/*
Adapter는 실생황에서는 100v 를 220v로 변경해주거나, 그 반대로 해주는 변환기를 예로 들 수 있다.
호환성이 없는 기존 클래스의 인터페이스를 변환하여 재사용 할 수 있도록 한다.
SOLID중에서 개방폐쇄 원칙(OCP)를 따른다.
*/
public class Adapter implements Electronic110V{

    private Electronic220V electronic220V;
    public Adapter(Electronic220V electronic220V){
        this.electronic220V = electronic220V;
    }
    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}
