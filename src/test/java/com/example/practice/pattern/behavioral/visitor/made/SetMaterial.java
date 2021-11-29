package com.example.practice.pattern.behavioral.visitor.made;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 对象结构角色
public class SetMaterial {
    private List<Material> list = new ArrayList<Material>();

    public String accept(Company visitor){
        Iterator<Material> iterator = list.iterator();
        String temp="";
        while(iterator.hasNext()){
            temp+=iterator.next().accept(visitor)+" ";
        }
        return temp;
    }

    public void add(Material material){
        list.add(material);
    }

    public void remove(Material material){
        list.remove(material);
    }

}
