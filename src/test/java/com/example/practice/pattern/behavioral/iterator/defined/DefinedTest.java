package com.example.practice.pattern.behavioral.iterator.defined;

public class DefinedTest {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("A");
        aggregate.add("B");
        aggregate.add("C");
        Iterator iterator = aggregate.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(iterator.first());
    }
}
