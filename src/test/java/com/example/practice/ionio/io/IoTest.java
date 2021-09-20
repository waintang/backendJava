package com.example.practice.ionio.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * io 流测试
 */
public class IoTest {
    public static void main(String[] args) throws IOException {
        // 0、默认字符集、文件测试
        charsetTest();
        fileTest();
//        PrintStream printStream = System.out;
        // 1、System.out 替换 默认流
//        FileOutputStream fdOut = new FileOutputStream("twp.log");
//        System.setOut(new PrintStream(fdOut,true));
        // 1、System.out 还原 默认流
//        FileOutputStream fdOut2 = new FileOutputStream (FileDescriptor.out);
//        System.setOut(new PrintStream(new BufferedOutputStream(fdOut2, 128), true));
//        System.setOut(printStream);

        //2、字节组流
//         byteArrayTest();

        //3、字符组流
//        charArrayTest();
//        File file = new File("");

        //4、管道
//        pipedTest();

        //5、组合流
//        combinePushbackTest();

        // 6、字符流
//        readerWriterTest();

        // 7、RandomAccessFile 随机操作文件
//        randomAccessFileTest();

        // 8、RandomAccessFile 随机操作文件（插入、但不覆盖）
//        randomAccessFileInsertNoCoverTest();
        // 9、其它流 测试
//        specialStreamTest();
    }


    private static void charsetTest() {
        System.out.println("默认字符集:" + Charset.defaultCharset());
    }

    private static void fileTest(){
        // -1 创建文件夹
        File file = new File("TWP22/ttwwpp");
        try {
            System.out.println(file.getCanonicalPath()); //E:\_github\waintang\backendJava\TWP2
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.exists());
        if(!file.exists()&&!file.isDirectory()){
            file.mkdirs();
            System.out.println("创建成功");
        }else{
            System.out.println("已存在");
        }
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
        CharArrayWriter writer = new CharArrayWriter();
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

    // RandomAccessFile 随机操作文件
    private static void randomAccessFileTest(){
        try(RandomAccessFile randomAccessFile = new RandomAccessFile(".\\randomAccessFileTest.txt","rw")) {
            char char0 = randomAccessFile.readChar();
            System.out.println(char0);
            long filePointer = randomAccessFile.getFilePointer();
            System.out.println(filePointer);
            randomAccessFile.seek(3);
            // 覆盖了位置3 的符号
            randomAccessFile.write('k');

            // 读取剩余的 字符行
            String string = randomAccessFile.readLine();
            System.out.println(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // RandomAccessFile 随机操作文件（插入、但不覆盖）
    private static void randomAccessFileInsertNoCoverTest() {

        // 0、需要临时文件 保存 插入点后续字符串
        File tempFile = null;
        try {
            tempFile = File.createTempFile("temp",".txt");
            System.out.println(tempFile.getName());//temp6118859074246846355.txt
            System.out.println(tempFile.getPath());//C:\Users\TWP\AppData\Local\Temp\temp6118859074246846355.txt
            tempFile.delete();
            //虚拟机关闭时，自动删除
            tempFile.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(RandomAccessFile randomAccessFile = new RandomAccessFile(".\\randomAccessFileTest.txt","rw");
            FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
            FileInputStream fileInputStream = new FileInputStream(tempFile);) {

            //1、插入点
            randomAccessFile.seek(3);
            long filePointer = randomAccessFile.getFilePointer();

            // 2、备份 插入点 后续字符串
            byte[] bytes = new byte[20];
            int flag = randomAccessFile.read(bytes);
            if(flag != -1){
                fileOutputStream.write(bytes);
                flag = randomAccessFile.read(bytes);
            }
            fileOutputStream.flush();
            // 2、在 插入点 插入
            randomAccessFile.seek(filePointer);
            randomAccessFile.write("特定字符串".getBytes());

            //3、还原插入点后 字符串
            int readFlag = fileInputStream.read(bytes);
            if(readFlag != -1){
                randomAccessFile.write(bytes);
                readFlag = fileInputStream.read(bytes);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 其它流 测试
    private static void specialStreamTest(){
        try(StringReader stringBuffer = new StringReader("Mary had 1 little lamb...")){
            StreamTokenizer tokenizer = new StreamTokenizer(stringBuffer);
            while(tokenizer.nextToken() != StreamTokenizer.TT_EOF){
                if(tokenizer.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println(tokenizer.sval);
                } else if(tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println(tokenizer.nval);
                } else if(tokenizer.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
