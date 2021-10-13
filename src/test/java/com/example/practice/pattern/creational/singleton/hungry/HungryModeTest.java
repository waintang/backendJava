package com.example.practice.pattern.creational.singleton.hungry;

import java.io.*;

public class HungryModeTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HungryMode hungryMode = HungryMode.getInstance();
        hungryMode.print();

        // 测试: 反序列化 破解单例模式 ( 序列化 必须实现Serializable,否则报错java.io.NotSerializableException )
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(hungryMode);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        HungryMode hungryMode1 = (HungryMode)ois.readObject();

        // readResolve()私有方法 可以保持单例
        System.out.println(hungryMode == hungryMode1);
    }
}
