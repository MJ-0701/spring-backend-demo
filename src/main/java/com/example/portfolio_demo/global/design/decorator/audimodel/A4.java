package com.example.portfolio_demo.global.design.decorator.audimodel;

import com.example.portfolio_demo.global.design.decorator.Audi;
import com.example.portfolio_demo.global.design.decorator.AudiDecorator;
import com.example.portfolio_demo.global.design.decorator.ICar;

public class A4 extends AudiDecorator {

    public A4(ICar audi, String modelName) {
        super(audi, modelName, 2000);
    }
}
