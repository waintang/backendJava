package com.example.practice.pattern.behavioral.visitor.defined;

public class DefinedTest {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor visitorA = new ConcreteVisitorA();
        os.accept(visitorA);

        System.out.println("------------");
        Visitor visitorB = new ConcreteVisitorB();
        os.accept(visitorB);
    }
}
