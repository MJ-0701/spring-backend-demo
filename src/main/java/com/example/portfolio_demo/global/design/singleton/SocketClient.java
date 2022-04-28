package com.example.portfolio_demo.global.design.singleton;

/*
어떠한 클래스가 유일하게 1개만 존재 할 떄 사용
이를 주로 사용하는 곳은 서로 자원을 공유 할 때 사용하는데, 실물 세계에서는 프린터가 해당되며,
실제 프로그래밍에서는 TCP Socket 통신에서 서버와 연결된 connect 객체에 주로 사용한다.
*/
public class SocketClient { // 싱글톤 패턴

    private static SocketClient socketClient = null;

    private SocketClient(){

    }

    public static SocketClient getInstance(){
        if(socketClient == null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect(){
        System.out.println("connect");
    }
}
