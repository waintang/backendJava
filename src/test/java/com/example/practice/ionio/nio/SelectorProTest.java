package com.example.practice.ionio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 【改造SelectorTest】
 *
 * 生产环境 一般怎么用 ServerSocketServer、Selector？
 * 答：一般用多线程、用在spring项目启动监听的时候
 */
public class SelectorProTest {
    public static void main(String[] args) {
        //曾犯错：端口号 最好外部传入，而非类内写死
        new Thread(new NioServerRunnable(8882)).start();
    }

    private static class NioServerRunnable implements Runnable {
        private static ServerSocketChannel serverSocketChannel;
        private static Selector selector ;

        //最好定义 ，给死循环 一个可以外部暂停的口子
        private boolean running = true;
        // 考虑 一个channel 重复响应！
        private boolean hadWrited = false;

        NioServerRunnable(int port){
            try {
                serverSocketChannel = ServerSocketChannel.open();
                //曾犯错：此处selector是成员变量，不需要 Selector selector = Selector.open();
                selector = Selector.open();

                serverSocketChannel.bind(new InetSocketAddress(port));
                serverSocketChannel.configureBlocking(false);// 少这句 会报： java.nio.channels.IllegalBlockingModeException
                serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
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
                        //曾犯错：少写remove()，将随机报错NullPointerException、堆内存移除
                        iterator.remove();
                        // 曾犯错：建议 原生SelectionKey 传递下去，而非 selectionKey.channel()！ （因为 SelectionKey 本身还带有其它信息、功能）
//                        SelectableChannel selectableChannel = selectionKey.channel();
                        if(selectionKey.isValid() && selectionKey.isAcceptable()){
                            register(selectionKey);
                            // SelectionKey 可能失效（主动cancel()、channel被关、selector被关）
                        }else if(selectionKey.isValid() && selectionKey.isReadable()){
                            read(selectionKey);
                            hadWrited = false;
                        }else if(selectionKey.isValid() && selectionKey.isWritable() && !hadWrited){
                            write(selectionKey);
                            hadWrited = true;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private static void register(SelectionKey selectionKey) throws IOException {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector,SelectionKey.OP_READ);
        }

        private static void read(SelectionKey selectionKey) throws IOException {
            SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            StringBuilder sb = new StringBuilder();
            while(socketChannel.read(byteBuffer) > 0){
//                byteBuffer.flip();// 按我理解，直接取Buffer的内存字节数据，不需要经过 flip过程
                sb.append(new String(byteBuffer.array(),"UTF-8"));
//                byteBuffer.clear();
            }
            System.out.println("收到客户端["+socketChannel.getRemoteAddress()+"]请求数据："+sb.toString());

            // 给 SelectionKey 附加对象（如 自定义回复消息）的两种方式：1、register的时候，2、SelectionKey.attach();
            // 但 注意：方法2必须在register之后！否则取不到数据
            String rtnResult = "自定义回复消息";
            // 收到请求数据后、处理、注册回写事件
//            socketChannel.register(selector,SelectionKey.OP_WRITE,rtnResult);
            socketChannel.register(selector,SelectionKey.OP_WRITE);
            selectionKey.attach(rtnResult);// 必须在register之后
        }

        private static void write(SelectionKey selectionKey){
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
