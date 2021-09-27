package com.example.practice.ionio.nio.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多Reactor多线程模型
 *
 * 举例：【父母送小朋友 去 游乐场】
 * 游乐场（Reactor单线程类）前台发现 小朋友是第一次来，就dispatch()分配一个 二级前台小姐姐（SubReactor）、二级前台小姐姐 领取玩具旁（executor.submit新线程）自己玩；
 *      出去上个洗手间，回来（第二次进）就不再分配了，直接找 二级前台小姐姐（SubReactor） 领去下一个玩具
 *
 *      TODO 没有 按类 进行拆分
 *      TODO 存在bug（启动成功，但无响应，客户端也无法收到响应）
 */
public class SelectorProMultiReactorMultiThreadTest {

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
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT,new MultiWorkThreadAcceptor());
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

    private static class SubReactor implements  Runnable{

        static Selector mySelector;

        int workCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(workCount);

        public SubReactor() throws IOException {
            this.mySelector= SelectorProvider.provider().openSelector();
        }

        public void registerChannel(SocketChannel socketChannel) throws ClosedChannelException {
            try {
                socketChannel.configureBlocking(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            socketChannel.register(mySelector,SelectionKey.OP_READ|SelectionKey.OP_CONNECT);
        }

        @Override
        public void run() {
            while(true){
                try {
                    int selectCnt = mySelector.select();
                    Set<SelectionKey> selectionKeys = mySelector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while(iterator.hasNext()){
                        SelectionKey selectionKey = iterator.next();
                        iterator.remove();
                        if(selectionKey.isReadable()){
                            read(selectionKey);
                        }else if (selectionKey.isWritable()){
                            write(selectionKey);
                        }
                    }
                    if(selectCnt == 0){
                        continue;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void read(SelectionKey selectionKey){
                doRead(selectionKey);
//                executorService.submit(()->doRead());
        }

        private void doRead(SelectionKey selectionKey){
            SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            try {
                socketChannel.read(byteBuffer);
                System.out.println("收到客户端["+socketChannel.getRemoteAddress()+"]的消息："+new String(byteBuffer.array()));

                socketChannel.configureBlocking(false);
                socketChannel.register(mySelector,SelectionKey.OP_WRITE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void write(SelectionKey selectionKey){
                doWrite(selectionKey);
//                executorService.submit(()->doWrite());
        }

        private void doWrite(SelectionKey selectionKey){
            SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
            try {
                socketChannel.write(ByteBuffer.wrap(("我是服务端，已收到你["+socketChannel.getRemoteAddress()+"]的消息").getBytes()));
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //Acceptor 处理所有连接
    static class MultiWorkThreadAcceptor  implements Runnable {
        int workCount = Runtime.getRuntime().availableProcessors();
        SubReactor[] workThreadHandlers = new SubReactor[workCount];
        volatile int nextHandler = 0;

        public MultiWorkThreadAcceptor(){
            this.init();
        }

        public void init(){
            nextHandler = 0;
            for(int i =0; i< workCount;i++){
                try{
                    workThreadHandlers[i] = new SubReactor();
                    Thread thread = new Thread(workThreadHandlers[i]);
                    thread.start();
                }catch (Exception e){

                }
            }
        }

        @Override
        public void run() {
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if(socketChannel != null){
                    SubReactor work = workThreadHandlers[nextHandler];
                    work.registerChannel(socketChannel);
                    nextHandler++;
                    if(nextHandler >= workCount){
                        nextHandler = 0;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
