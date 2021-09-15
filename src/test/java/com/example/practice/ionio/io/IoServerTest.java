package com.example.practice.ionio.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class IoServerTest {

    public static void main(String[] args) {
        concurrencyServerTest();
    }

    // 并发IO 服务端
    private static void concurrencyServerTest(){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            while((socket = serverSocket.accept())!=null){
                new ConcurrencyServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ConcurrencyServerThread extends  Thread{
        Socket socket ;
        ConcurrencyServerThread(Socket socket ){
            this.socket = socket;
        }
        @Override
        public void run() {
            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"))) {
                String line = bufferedReader.readLine();
                while(!"Bye".equals(line)){
                    System.out.println(line);
//                    socket.getOutputStream().write(("已收到消息："+line).getBytes("UTF-8"));
                    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8")),true);
                    pw.println("已收到消息："+line);
                    line = bufferedReader.readLine();
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
