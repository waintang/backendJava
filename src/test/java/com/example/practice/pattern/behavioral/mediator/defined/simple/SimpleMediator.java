package com.example.practice.pattern.behavioral.mediator.defined.simple;

import java.util.ArrayList;
import java.util.List;

public class SimpleMediator {
    private static SimpleMediator simpleMediator = new SimpleMediator();

    private List<Colleague> colleageList = new ArrayList<Colleague>();

    public static SimpleMediator getSimpleMediator(){
        return simpleMediator;
    }

    public void register(Colleague colleague){
        if(!colleageList.contains(colleague)){
            colleageList.add(colleague);
        }
    }

    public void relay(Colleague colleague,String info) {
        for(Colleague co: colleageList){
            if(co != colleague){
                co.receive(info);
            }
        }
    }

}
