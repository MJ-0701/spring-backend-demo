package com.example.portfolio_demo.global.utils.encode;

public class Encoder {

    private IEncoder iEncoder;

    // 굉장히 비효율 적이고 위험함
    /*public Encoder(){
        // this.iEncoder = new Base64Encoder();
        // this.iEncoder = new UrlEncoder();
    }*/

    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String msg){
        return iEncoder.encode(msg);
    }
}
