package com.example.practice.io.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @description：NIO-单线程单Reactor模式
 * @author：tavion
 * @date：2021/7/29 14:37
 */
public class SingleThreadReactorTest {

    Selector selector;
    ServerSocketChannel serverSocketChannel;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9099);
    }
}
