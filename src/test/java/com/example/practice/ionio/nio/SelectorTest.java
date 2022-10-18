package com.example.practice.ionio.nio;

import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class SelectorTest {

    public static void main(String[] args) throws IOException {
        testSelector();
    }

    public static void testSelector() throws IOException {
        // SelectorProvider（管理SocketChannel/ServerSocketChannel/DatagramChannel & AbstractSelector） 、
        // 不同openSelector得到不同AbstractSelector
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8882));
        int interestSet = SelectionKey.OP_ACCEPT|SelectionKey.OP_CONNECT|SelectionKey.OP_READ|SelectionKey.OP_WRITE;
        // 服务端 只能 register成 OP_ACCEPT
        // OP_CONNECT 只能用在 客户端
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT );
        while(true){
            int readyChannels = selector.select();
            //((WindowsSelectorImpl) selector).channelArray 可以查看 动态的 selector管理的 channel个数
            System.out.println("readyChannels:"+readyChannels);
            if(readyChannels == 0){
                continue;
            }

            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = selectionKeySet.iterator();
            while(selectionKeyIterator.hasNext()){
                SelectionKey selectionKey = selectionKeyIterator.next();
                //为什么在这remove
                selectionKeyIterator.remove();

                selectionKey.interestOps();
                selectionKey.readyOps();
                SelectableChannel selectableChannel = selectionKey.channel();
                // telnet 只连接OP_ACCEPT、不传数
                // curl 不只连接OP_ACCEPT、还传数OP_READ
                if(selectionKey.isAcceptable()){
                    // 获取客户端连接
                    SocketChannel socketChannel = ((ServerSocketChannel)selectableChannel).accept();
                    socketChannel.configureBlocking(false);
                    // 注册读事件到选择器上，等待客户端发送内容
                    socketChannel.register(selector, SelectionKey.OP_READ);

                    System.out.println("客户端[" + socketChannel.getRemoteAddress() + "]接入");

                    //是否可连接
                }else if(selectionKey.isConnectable()){
                    //是否已连接
                }else if(selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    // #############start 获取客户端 发送来的 报文
                    ByteBuffer byteBufferHeader = ByteBuffer.allocate(1024);
                    socketChannel.read(byteBufferHeader);
                    byteBufferHeader.flip();
                    byte[] request = new byte[0];
                    while (byteBufferHeader.hasRemaining()){
                        request = ArrayUtils.addAll(request,new byte[]{byteBufferHeader.get()});
                    }
                    for(byte requestByte : request){
                        System.out.print(requestByte+" " );
                    }
                    System.out.println("");
                    StringBuilder sb = new StringBuilder();
                    for(byte requestByte : request){
                        sb.append((char)requestByte);
                    }
                    System.out.println(sb.toString());
                    byteBufferHeader.clear();
                    // #############end 获取客户端 发送来的 报文
//                    socketChannel.write(ByteBuffer.wrap("你说啥，我看不懂".getBytes(StandardCharsets.UTF_8)));
                    socketChannel.write(ByteBuffer.wrap("what are you say, i dont know.".getBytes()));
                    System.out.println("回复客户端[" + socketChannel.getRemoteAddress() + "]:你说啥，我看不懂");
                    // 12、关闭相关资源
                    socketChannel.close();
                    //是否有可读数据
                }else if(selectionKey.isWritable()){
                    //是否有 可写数据
                }
            }

        }
//        serverSocketChannel.close();
        // TODO Selector的select() 方法 存在 用线程的 wait阻塞方法，达到监控不同Channel？
    }

}
