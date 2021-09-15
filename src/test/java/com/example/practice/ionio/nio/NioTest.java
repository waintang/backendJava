package com.example.practice.ionio.io.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NioTest {

    /**
     * 阻塞io
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8117);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line =  bufferedReader.readLine();
        System.out.println("收到客户端请求："+line);
        socket.close();
    }
}
