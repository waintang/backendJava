package com.example.practice.pattern.behavioral.mediator.defined.standard;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator{
    private List<Colleague> colleageList = new ArrayList<Colleague>();

    @Override
    public void register(Colleague colleague){
        if(!colleageList.contains(colleague)){
            colleageList.add(colleague);
            colleague.setMediator(this);
        }
    }

    @Override
    public void relay(Colleague colleague,String info) {
        for(Colleague co: colleageList){
            if(co != colleague){
                co.receive(info);
            }
        }
    }
}
