package com.example.portfolio_demo.global.design.singleton;



public class SingletonB {

    private SocketClient socketClient;

    public SingletonB(){
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }

}
