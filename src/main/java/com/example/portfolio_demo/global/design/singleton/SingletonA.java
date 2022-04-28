package com.example.portfolio_demo.global.design.singleton;



public class SingletonA {

    private SocketClient socketClient;

    public SingletonA(){
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }

}
