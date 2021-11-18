package com.example.practice.pattern.behavioral.interpreter.bus;

public class BusContext {
    private String[] citys = {"韶关","广州"};
    private String[] persons = {"老人","儿童"};
    private Expression cityPersonExpression ;
    public BusContext(){
        Expression city = new TerminalExpression(citys);
        Expression person = new TerminalExpression(persons);
        cityPersonExpression = new AndExpression(city,person);
    }

    public void rideBus(String info){
        if(cityPersonExpression.interpret(info)){
            System.out.println("免费");
        }else{
            System.out.println("扣两元");
        }
    }

}
