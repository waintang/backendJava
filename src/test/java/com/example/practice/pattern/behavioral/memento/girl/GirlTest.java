package com.example.practice.pattern.behavioral.memento.girl;

public class GirlTest {
    public static void main(String[] args) {
        Girl girl1 = new Girl("西施");
        Girl girl2 = new Girl("貂蝉");
        Girl girl3 = new Girl("王昭君");
        Girl girl4 = new Girl("杨玉环");

        GirlStack girlStack = new GirlStack();

        You you =new You();
        you.setWifeName(girl1.getName());
        girlStack.push(you.createMemento());
        System.out.println("第一次选择："+you.getWifeName());
        you.setWifeName(girl2.getName());
        girlStack.push(you.createMemento());
        System.out.println("第二次选择："+you.getWifeName());
        you.setWifeName(girl3.getName());
        girlStack.push(you.createMemento());
        System.out.println("第三次选择："+you.getWifeName());

        Girl back = girlStack.pop();
        System.out.println("最后一次备份："+back.getName());
        back = girlStack.pop();
        System.out.println("倒数第二次备份："+back.getName());
    }
}
