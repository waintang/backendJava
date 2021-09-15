package com.example.practice.ionio.io;

import com.sun.xml.internal.messaging.saaj.util.CharWriter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * io 流测试
 */
public class IoTest {
    public static void main(String[] args) throws IOException {
        // 0、默认字符集
        charsetTest();
//        PrintStream printStream = System.out;
        // 1、System.out 替换 默认流
//        FileOutputStream fdOut = new FileOutputStream("twp.log");
//        System.setOut(new PrintStream(fdOut,true));
        // 1、System.out 还原 默认流
//        FileOutputStream fdOut2 = new FileOutputStream (FileDescriptor.out);
//        System.setOut(new PrintStream(new BufferedOutputStream(fdOut2, 128), true));
//        System.setOut(printStream);

        //2、字节流
//         byteArrayTest();

        //3、字符流
//        charArrayTest();
//        File file = new File("");

        //4、管道
//        pipedTest();

        //5、组合流
//        combinePushbackTest();

        // 6、字符流
        readerWriterTest();
    }


    private static void charsetTest() {
        System.out.println("默认字符集:" + Charset.defaultCharset());
    }

    private static void byteArrayTest() throws IOException {
        System.out.println("========start ByteArrayInputStream==========");
        byte[] bytes = new byte[2];
        bytes[0] = 2;
        bytes[1] = -2;
        InputStream inputStream = new ByteArrayInputStream(bytes);
        int data = inputStream.read();
        System.out.println(data);
        while (data != -1) {
            data = inputStream.read();
            System.out.println(data);
        }
        System.out.println("========end ByteArrayInputStream==========");

        System.out.println("========start ByteArrayOutputStream==========");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write("i'm English和中文!".getBytes("UTF-8"));
        byte[] outputBytes = outputStream.toByteArray();
        outputStream.flush();
        System.out.println("outputBytes的长度：" + outputBytes.length);
        System.out.println(outputBytes);
        System.out.println("========end ByteArrayOutputStream==========");

    }

    private static void charArrayTest() throws IOException {
        System.out.println("========start CharArrayReader==========");
        char[] chars = {'a', 'b', 'c'};// new char[3];
        Reader reader = new CharArrayReader(chars);
        int charData = reader.read();
        System.out.println((char) charData);
        while (charData != -1) {
            charData = reader.read();
            System.out.println((char) charData);
        }
        System.out.println("========end CharArrayReader==========");

        System.out.println("========start CharWriter==========");
        CharWriter writer = new CharWriter();
        writer.write("我是中文！".toCharArray());
        char[] writeChars = writer.toCharArray();
        writer.flush();
        System.out.println("writeChars的长度：" + writeChars.length);
        System.out.println("当前字符编码的值：" + (int) writeChars[0]);//25105
        System.out.println(writeChars);
        System.out.println("========end CharWriter==========");
    }

    // 管道  测试
    private static void pipedTest() throws IOException {
        PipedOutputStream output = new PipedOutputStream();
        PipedInputStream input = new PipedInputStream(output);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    output.write("1233adf".getBytes("UTF-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(null!=output){
                        try {
                            output.close();
                            System.out.println("output已关闭。");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("线程1结束。");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2开始。");
                int data = 0;
                try {
                    data = input.read();
                    while (data != -1) {
                        System.out.println((char) data);
                        data = input.read();
                    }
                    System.out.println("线程2结束。");
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(null!=input){
                        try {
                            input.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }

    //组合流测试  如：PushbackInputStream、BufferedInputStream、SequenceInputStream、
    private static void combinePushbackTest() {
        try(PushbackInputStream pushbackInputStream = new PushbackInputStream(new FileInputStream(".\\combineTest.txt"),1);) {
            int data1 = pushbackInputStream.read();
            System.out.println((char)data1);
            int data2 = pushbackInputStream.read();
            System.out.println((char)data2);
            // 放回
            pushbackInputStream.unread(data1);
            // 最多只能放回 指定个数个 元素 =》 因为size=1，所以unread放回第二个会抛错
            pushbackInputStream.unread(data2);

            int data3 = pushbackInputStream.read();
            System.out.println((char)data3);
            int data4 = pushbackInputStream.read();
            System.out.println((char)data4);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //字符流
    private static void readerWriterTest(){
        try(Reader reader = new InputStreamReader(new FileInputStream(".\\readerWriterTest.txt"))){
            int data = reader.read();
            System.out.println(data);
            System.out.println((char)data);
            data = reader.read();
            System.out.println((char)data);
            data = reader.read();
            System.out.println((char)data);
            data = reader.read();
            System.out.println(data);
            System.out.println((char)data);
            data = reader.read();
            System.out.println(data);
            System.out.println((char)data);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
