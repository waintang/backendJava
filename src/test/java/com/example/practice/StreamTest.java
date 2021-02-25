package com.example.practice;

public class StreamTest {
    public static void main(String[] args) {
        System.out.println(InnerClass.class);
    }

    public class InnerClass{
        private int a;
        public int test(){
            return 1;
        }
    }
}
