package com.example.practice.pattern.behavioral.mediator.estate;

import java.util.ArrayList;
import java.util.List;

public class EstateMediator implements Mediator{
    private List<Customer> customers = new ArrayList<>();
    public void register(Customer member){
        if(!customers.contains(member)){
            customers.add(member);
            member.setMediator(this);
        }
    }
    public void relay(String name,String info){
        for(Customer customer : customers){
            if(!name.equals(customer.getName())){
                customer.receive(name,info);
            }
        }
    }
}
