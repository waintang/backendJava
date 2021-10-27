package com.example.practice.ionio.nio.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 单Reactor多线程模型
 *
 * 举例：【父母送小朋友 去 游乐场】
 * 游乐场（Reactor单线程类）前台发现 小朋友是第一次来，就dispatch()分配一个服务员小姐姐（Handler）送去玩具（线程池）旁边，让小朋友自己玩，服务员忙别的去了；
 *      出去上个洗手间，回来（第二次进）就不员工再分配了，直接找服务员（Handler）领去下一个玩具
 *
 *     TODO 没有 按类 进行拆分
 */
public class SelectorProReactorMultiThreadTest {

    private static ServerSocketChannel serverSocketChannel;
    private static Selector selector ;

    public static void main(String[] args) {
        //曾犯错：端口号 最好外部传入，而非类内写死
        new Thread(new SingleReactor(8882)).start();
    }

    private static class SingleReactor implements Runnable {

        SingleReactor(int port){
            try {
                serverSocketChannel = ServerSocketChannel.open();
                //曾犯错：此处selector是成员变量，不需要 Selector selector = Selector.open();
                selector = Selector.open();

                serverSocketChannel.bind(new InetSocketAddress(port));
                serverSocketChannel.configureBlocking(false);// 少这句 会报： java.nio.channels.IllegalBlockingModeException
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT,new Acceptor());
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
                    new MultiThreadHandler(socketChannel,selector);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    static class MultiThreadHandler implements Runnable {

        public static final int READING = 0,WRITING=1;
        private  int stat ;
        private SocketChannel socketChannel;
        //        private Selector selector; // 此处可以仅保存 SelectionKey即可
        private SelectionKey selectionKey;

        // 线程池处理业务逻辑（cpu核数）
//        private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        private ExecutorService executorService = Executors.newFixedThreadPool(2);

        public MultiThreadHandler(SocketChannel socketChannel, Selector selector) throws IOException {
            this.socketChannel = socketChannel;
            //曾犯错：configureBlocking(false)，将报错：java.nio.channels.IllegalBlockingModeException
            socketChannel.configureBlocking(false);
            this.selectionKey = socketChannel.register(selector,SelectionKey.OP_READ);
            this.stat = READING;
            selectionKey.attach(this);
        }

        @Override
        public void run() {
            if(stat == READING){
                read();
            } else if(stat == WRITING){
                write();
            }
        }


        private void read() {
            if(selectionKey.isReadable()){
                //TODO bag：实际运行时，这里会反复运行，但客户端不受影响、无感知（问题同 ()->doWrite() ）
                Future future = executorService.submit(()->doRead());
                future.isDone();
                // 此连接 重新更改关注事件 成： 写事件
                selectionKey.interestOps(SelectionKey.OP_WRITE);
                selectionKey.attach(this);
                stat = WRITING;
            }
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

        // 异步写，被
        private void write(){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if(selectionKey.isWritable()){
                doWrite();
            }
            // 异步写 将关闭连接“java.io.IOException: 远程主机强迫关闭了一个现有的连接。”
//            Future future =executorService.submit(()->doWrite());
//            future.isDone();
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
//                selectionKey.interestOps(SelectionKey.OP_READ);
//                this.stat = READING;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
