package com.example.practice.pattern.structural.facade.defined;

// 外观角色
public class Facade {
    private SubSystem01 subSystem01 = new SubSystem01();
    private SubSystem02 subSystem02 = new SubSystem02();
    private SubSystem03 subSystem03 = new SubSystem03();

    public void method(){
        subSystem01.method1();
        subSystem02.method2();
        subSystem03.method3();
    }

}
