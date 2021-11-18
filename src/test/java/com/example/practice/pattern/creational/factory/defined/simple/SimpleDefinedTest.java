package com.example.practice.pattern.creational.factory.defined.simple;

public class SimpleDefinedTest {
    public static void main(String[] args) {
        Product product = SimpleFactory.creteProduct(Const.PRODUCT_A);
        product.show();
    }
}
