package com.example.practice.ionio.nio;

import java.io.IOException;
import java.nio.channels.Selector;

public class SelectorMain {

    public static void main(String[] args) {

    }

    public static void testSelector() throws IOException {
        // SelectorProvider（管理SocketChannel/ServerSocketChannel/DatagramChannel & AbstractSelector） 、
        // 不同openSelector得到不同AbstractSelector
        Selector selector = Selector.open();
        // TODO Selector的select() 方法 存在 用线程的 wait阻塞方法，达到监控不同Channel？
    }

}
