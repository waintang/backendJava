package com.example.practice.pattern.behavioral.memento.girl;


//管理者：美女栈
public class GirlStack {
    private Girl[] girls;
    private int top;

    public GirlStack(){
        girls = new Girl[5];
        top = -1;
    }

    public boolean push(Girl g){
        if(top>=4){
            System.out.println("最多备忘存4个");
            return false;
        }
        girls[++top] = g;
        return true;
    }

    public Girl pop(){
        if(top<=0){
            System.out.println("没有备份的女孩了");
            return girls[0];
        }else{
            return girls[top--];
        }
    }

}
