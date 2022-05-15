package com.example.portfolio_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class PortfolioDemoApplication {

    private final static int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        SpringApplication.run(PortfolioDemoApplication.class, args);

        // 서버 인스턴스 생성
        try(ServerSocket server = new ServerSocket()){
            // 8080 포트에 서버를 대기시킨다.
            InetSocketAddress inetSocketAddress = new InetSocketAddress(9999);
            // 서버 인스턴스에 소켓 정보 바인드
            server.bind(inetSocketAddress);
            // 콘솔 출력으로 확인
            System.out.println("Initialize Complete");
            // 클라이언트로 부터 메시지를 대기하는 스래드 풀
            ExecutorService receiver = Executors.newCachedThreadPool();
            // 클라이언트 리스트
            List<Socket> list = new ArrayList<>();

            // 서버는 무한 대기
            while(true){
                try{
                    // 클라이언트 접속 대기
                    Socket client = server.accept();
                    // 클라이언트 리스트 추가
                    list.add(client);
                    System.out.println("Client connected IP address =" + client.getRemoteSocketAddress().toString());
                    // 클라이언트 스래드 풀 시작
                    receiver.execute(() -> {
                        // 클라이언트가 종료되면 socket을 close 한다.
                        // OutputStream 과 InputStream 을 받는다.
                        try(Socket thisClient = client;
                            OutputStream send = client.getOutputStream();
                            InputStream recev = client.getInputStream();){
                            // message 작성
                            String msg = "Welcome server!\r\n";
                            // byte 변환
                            byte[] b = msg.getBytes();
                            // 클라이언트 전송
                            send.write(b);
                            // 버퍼
                            StringBuffer sb = new StringBuffer();
                            // 메세지 루프 대기
                            while (true){
                                // 버퍼 생성
                                b = new byte[BUFFER_SIZE];
                                // 메세지를 받는다.
                                recev.read(b, 0, b.length);
                                // byte를 스트링으로 변환
                                msg = new String(b);
                                // 버퍼에 메세지 추가
                                sb.append(msg.replace("\0",""));
                                // 메세지가 개행일 경우(클라이언트에서 엔터를 친 경우)
                                if (sb.length() > 2 && sb.charAt(sb.length() - 2) == '\r' && sb.charAt(sb.length() - 1) == '\n'){
                                    // 메세지를 String 으로 변환
                                    msg = sb.toString();
                                    // 버퍼 비우기
                                    sb.setLength(0);
                                    // 메세지 콘솔출력
                                    System.out.println(msg);
                                    // exit 메세지일 경우 메시지 대기루프 종료
                                    if("exit\r\n".equals(msg)){
                                        break;
                                    }
                                    // echo 메세지 작성
                                    msg = "echo :" + msg + ">";
                                    //byte 로 변환
                                    b = msg.getBytes();
                                    //client 로 전송
                                    send.write(b);
                                }
                            }
                        } catch (Throwable e) {
                            // 에러 발생시 메세지 출력
                            e.printStackTrace();
                        } finally {
                            // 접속이 종료되면 접속 정보를 콘솔에 출력
                            System.out.println("Client disconnected IP address =" + client.getRemoteSocketAddress().toString());

                        }
                    });
                }catch (Throwable e){
                    e.printStackTrace();
                }
            }
        }catch (Throwable e) {
            e.printStackTrace();
        }
    }
    /*
    위에서 accept는 while(true)로 무한 루프 안에 넣어서 클라이언트를 대기하고 있습니다.
    클라이언트 접속이 되면 스레드 풀에 Socket을 넘겨서 클라이언트로 부터 메시지를 대기합니다.
    */



}
