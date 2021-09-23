package com.example.practice.ionio.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试 Buffer类
 *
 * 类型：
 * ByteBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * DoubleBuffer
 * FloatBuffer
 * CharBuffer
 * MappedBuffer
 *
 * 关键属性：capacity、position、limit
 * 关键方法：allocate()分配、flip()读、clear()清空、compact()准备继续写入、
 *          rewind()重读、mark() & reset()标记/恢复position、equals()相等、compareTo()比较
 *
 */
public class BufferMain {

    //基于ChannelMain例子、完善代码
    public static void main(String[] args) {

        try {
            // 默认文件夹 是 当前项目路径
            RandomAccessFile randomAccessFile = new RandomAccessFile("randomAccessFileForNio.txt","rw");
            System.out.println("文件长度："+randomAccessFile.length());
            FileChannel fileChannel = randomAccessFile.getChannel();
//            testClear(fileChannel);
            testCompact(fileChannel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testClear(FileChannel fileChannel) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(15);
        //  TODO FileChannel只能按 ByteBuffer 读取 问：怎么读取文件内容？
        int flag = fileChannel.read(buf);
        System.out.println("读取过程=》capacity："+buf.capacity()+"，limit："+buf.limit()+"，position："+buf.position());
        while(flag != -1){
            System.out.println(flag);
            // buffer内存区域需要 转换成 读状态，才能获取 内容
            buf.flip();
            System.out.println("capacity："+buf.capacity()+"，limit："+buf.limit()+"，position："+buf.position());
            while (buf.hasRemaining()){
                System.out.println(new String(new byte[]{buf.get(),buf.get(),buf.get()})); //这样很容易出现 BufferUnderflowException 异常
            }
            // clear只是还原了 position、limit位置 ，内存内容  没有被清空
            // 但是limit会跟着新内容走，不会读取到上次内存的内容
            buf.clear();
            flag = fileChannel.read(buf);
        }
    }

    public static void testCompact(FileChannel fileChannel) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(15);
        //  TODO FileChannel只能按 ByteBuffer 读取 问：怎么读取文件内容？
        int flag = fileChannel.read(buf);
        System.out.println("读取过程=》capacity："+buf.capacity()+"，limit："+buf.limit()+"，position："+buf.position());
        while(flag != -1){
            System.out.println(flag);
            // buffer内存区域需要 转换成 读状态，才能获取 内容
            buf.flip();
            System.out.println("capacity："+buf.capacity()+"，limit："+buf.limit()+"，position："+buf.position());
            System.out.println(new String(new byte[]{buf.get(),buf.get(),buf.get()})); //这样很容易出现 BufferUnderflowException 异常
            buf.compact();
            flag = fileChannel.read(buf);
        }
    }

    public static void testScatter(FileChannel fileChannel) throws IOException {
        ByteBuffer byteBufferHeader = ByteBuffer.allocate(6);
        ByteBuffer byteBufferBody = ByteBuffer.allocate(9);
        ByteBuffer[] bufferArray = { byteBufferHeader, byteBufferBody };

        long flag = fileChannel.read(bufferArray);
        if(flag != -1){
            byteBufferHeader.flip();// 后续读取操作
            byteBufferBody.flip();// 后续读取操作
        }

    }
}
