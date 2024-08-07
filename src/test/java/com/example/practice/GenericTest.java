package com.example.practice;

import cn.hutool.core.collection.ListUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit banana = new Banana();
        Person person = new Person();
        Generic<Fruit> generic = new Generic();
        generic.getName1(apple);
        generic.getName1(banana);
//        generic.getName1(person); // 编译报错：因为getName1的入参 继承自 类上的指定

        generic.getName2(apple);
        generic.getName2(banana);
        generic.getName2(person);
        // <E><T> 完全一致，和 类上的<T>不是一回事
        generic.getName3(apple);
        generic.getName3(banana);
        generic.getName3(person);

        // ********** 泛型入参 编译时会检查参数类型
        List strList = new ArrayList<>();
        List<Fruit> fruitList = new ArrayList<>();
        List<Apple> appleList = new ArrayList<>();
        testObjectList(strList); // 原始类型
//        testObjectList(appleList); // 会编译错误，因为Apple不等于Object
        testFruitList(appleList); // 上界通配符
    }

    // 泛型类、泛型方法
    private static class Generic<T> {
        public void getName1(T t){
            System.out.println("getName1:"+t.getClass().getName());
        }
        public <E> void getName2(E t){
            System.out.println("getName2:"+t.getClass().getName());
        }
        public <T> void getName3(T t){
            System.out.println("getName3:"+t.getClass().getName());
        }
    }

    // 基础DTO
    private interface Fruit{

    }
    private static class Apple implements Fruit{

    }
    private static class Banana implements Fruit{
        public Banana(){

        }

    }
    private static  class Person {

    }

    public static void testObjectList(List<Object> list){

    }

    public static void testFruitList(List<? extends Fruit> list){

    }
}
