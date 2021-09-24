package com.example.practice.ionio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorClientTest {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1",8882));
            socketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_READ);

            socketChannel.write(ByteBuffer.wrap("abcd".getBytes("UTF-8")));
//            for(;;){
                int select = selector.select();
//                if(select == 0){
//                    continue;
//                }
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    SelectableChannel channel = selectionKey.channel();
                    StringBuilder sb = new StringBuilder();
                    if(selectionKey.isReadable()){
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int readFlag = ((SocketChannel) channel).read(byteBuffer);
                        sb.append(new String(byteBuffer.array(),"UTF-8"));
//                        if(readFlag!=-1){
//                            while(byteBuffer.hasRemaining()){
//                                sb.append((char)byteBuffer.get());
//                            }
//                        }
                    }
                    System.out.println("服务端响应："+sb.toString());
                }

//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
