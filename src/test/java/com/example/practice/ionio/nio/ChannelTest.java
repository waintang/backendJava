package com.example.practice.ionio.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * Channel 通道 类型、测试
 *
 * FileChannel
 * SocketChannel（用在TCP连接）
 * ServerSocketChannel
 * DatagramChannel（用在UDP连接）
 */
public class ChannelTest {

    public static void main(String[] args) {
//        testChannel();
        try {
            testChannelFrmTo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testChannel(){
        try {
            // 默认文件夹 是 当前项目路径
            File file = new File("randomAccessFileForNio.txt");
            System.out.println(file.exists()+ " "+ file.getAbsolutePath()+" "+file.length());
            RandomAccessFile randomAccessFile = new RandomAccessFile("randomAccessFileForNio.txt","rw");
            System.out.println("文件长度："+randomAccessFile.length());
            FileChannel fileChannel = randomAccessFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(48);
            int flag = fileChannel.read(buf);
            while(flag != -1){
                System.out.println(flag);
                flag = fileChannel.read(buf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testChannelFrmTo() throws IOException {

        RandomAccessFile randomAccessFileFrm = new RandomAccessFile("randomAccessFileForNioFrom.txt","rw");
        FileChannel fileChannelFrom = randomAccessFileFrm.getChannel();

        RandomAccessFile randomAccessFileTo = new RandomAccessFile("randomAccessFileForNioTo.txt","rw");
        FileChannel fileChannelTo = randomAccessFileTo.getChannel();

//        long position = 0;
//        long count = fileChannelFrom.size();
//        fileChannelFrom.transferTo(position,count,fileChannelTo);

        long position = 0;
        long count = fileChannelTo.size();
        // TODO 这句有问题，似乎没有从 from文件写数据到to文件
        fileChannelTo.transferFrom(fileChannelFrom,position,count);

    }
}
