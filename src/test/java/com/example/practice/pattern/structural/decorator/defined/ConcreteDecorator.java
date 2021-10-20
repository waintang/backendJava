package com.example.practice.pattern.structural.decorator.defined;

public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component){
        super(component);
    }


    public void operation() {
        super.operation();
        addFunction();
    }

    public void addFunction(){
        System.out.println("具体装饰器 附加的方法" );
    }

}
