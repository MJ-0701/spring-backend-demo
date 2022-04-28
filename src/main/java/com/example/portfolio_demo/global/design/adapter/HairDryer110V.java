package com.example.portfolio_demo.global.design.adapter;

public class HairDryer110V implements Electronic110V{
    @Override
    public void powerOn() {
        System.out.println("헤어 드라이기 110v on");
    }
}
