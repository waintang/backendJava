package com.example.practice.pattern.structural.decorator.defined;

/**
 * 具体构件
 */
public class ConcreteComponent extends Component {

    public ConcreteComponent(){
        System.out.println("实例化了具体构件");
    }

    @Override
    public void operation() {
        System.out.println("调用了具体构件的operation()方法");
    }
}
