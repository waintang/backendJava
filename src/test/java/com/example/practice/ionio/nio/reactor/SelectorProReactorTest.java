package com.example.practice.ionio.nio.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 【再次改造 SelectorTest =》 SelectorProTest =》 SelectorProReactorTest】
 *
 * 单Reactor单线程模型  过程描述 ：
 * 单Reactor对象【单线程 循环监控select()得到连接、dispatch() 分发连接到 业务代码块 】
 *      分发逻辑： 1、新连接 走Acceptor类（单线程）转发至OP_READ（Handler单线程）  2、旧连接 直接走 Handler线程
 *
 * 全程 三个线程对象
 *
 *
 * 举例：【父母送小朋友 去 游乐场】
 * 游乐场（Reactor单线程类）前台发现 小朋友是第一次来，就dispatch()分配一个服务员小姐姐（Handler）全程陪着read/write；
 *      出去上个洗手间，回来（第二次进）就不员工再分配了，直接找服务员（Handler）
 *
 * TODO 没有 按类 进行拆分
 *
 */
public class SelectorProReactorTest {

    private static ServerSocketChannel serverSocketChannel;
    private static Selector selector ;

    public static void main(String[] args) {
        //曾犯错：端口号 最好外部传入，而非类内写死
        new Thread(new Reactor(8882)).start();
    }

    private static class Reactor implements Runnable {

        Reactor(int port){
            try {
                serverSocketChannel = ServerSocketChannel.open();
                //曾犯错：此处selector是成员变量，不需要 Selector selector = Selector.open();
                selector = Selector.open();

                serverSocketChannel.bind(new InetSocketAddress(port));
                serverSocketChannel.configureBlocking(false);// 少这句 会报： java.nio.channels.IllegalBlockingModeException
                serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT,new Acceptor());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while(true){
                try {
                    int selectCnt = selector.select();
                    if(selectCnt == 0){
                        continue;
                    }
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while(iterator.hasNext()){
                        SelectionKey selectionKey = iterator.next();
                        //曾犯错：少写remove()，将随机报错NullPointerException、堆内存溢出
                        iterator.remove();
                        dispatch(selectionKey);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        void dispatch(SelectionKey selectionKey){
                Runnable runnable = (Runnable)selectionKey.attachment();
                runnable.run();
        }

    }

    //Acceptor 处理所有连接
    static class Acceptor implements Runnable {

        @Override
        public void run() {
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if(socketChannel != null){
                    new Handler(socketChannel,selector);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    static class Handler implements Runnable {

        public static final int READING = 0,WRITING=1;
        private  int stat ;
        private SocketChannel socketChannel;
//        private Selector selector; // 此处可以仅保存 SelectionKey即可
        private SelectionKey selectionKey;

        public Handler(SocketChannel socketChannel,Selector selector) throws IOException {
            this.socketChannel = socketChannel;
            //曾犯错：configureBlocking(false)，将报错：java.nio.channels.IllegalBlockingModeException
            socketChannel.configureBlocking(false);
            this.selectionKey = socketChannel.register(selector,SelectionKey.OP_READ);
            this.stat = READING;
            selectionKey.attach(this);
            socketChannel.configureBlocking(false);
        }

        // 按我理解：此单reactor多线程下，
        // OP_READ、OP_WRITE 两事件 还必须 等待程序处理完成 才能响应
        @Override
        public void run() {
            if(stat == READING){
                read();
            } else if(stat == WRITING){
                write();
            }
        }


        private void read() {
            doRead();
            // 此连接 重新更改关注事件 成： 写事件
            selectionKey.interestOps(SelectionKey.OP_WRITE);
            stat = WRITING;
        }

        // 读 业务逻辑
        private void doRead() {
            SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            StringBuilder sb = new StringBuilder();
            try{
                while(socketChannel.read(byteBuffer) > 0){
//                byteBuffer.flip();// 按我理解，直接取Buffer的内存字节数据，不需要经过 flip过程
                    sb.append(new String(byteBuffer.array(),"UTF-8"));
//                byteBuffer.clear();
                }
                System.out.println("收到客户端["+socketChannel.getRemoteAddress()+"]请求数据："+sb.toString());
            } catch(IOException e){
                e.printStackTrace();
            }
        }

        private void write(){
            doWrite();
//            socketChannel.close();
//            selectionKey.interestOps(SelectionKey.OP_READ);
        }

        // 写 业务逻辑
        private void doWrite(){
            SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
            try {
                String rtnMsg = "服务器已回复客户端"+socketChannel.getRemoteAddress()+"消息。"+selectionKey.attachment().toString();
                socketChannel.write(ByteBuffer.wrap(rtnMsg.getBytes()));
                System.out.println(rtnMsg);
                // 别忘了close()
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
