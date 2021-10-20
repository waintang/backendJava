package com.example.practice.pattern.structural.decorator.defined;

/**
 * “抽象装饰器” 可以是抽象类、也可以是 具体类
 *
 * “抽象装饰器”“具体装饰器” 有的情况下，可以合二为一
 */
public /*abstract*/ class Decorator extends Component {

    private Component component ;

    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void operation() {
        System.out.println("装饰器对象调用了operation()方法");
        component.operation();
    }

}
