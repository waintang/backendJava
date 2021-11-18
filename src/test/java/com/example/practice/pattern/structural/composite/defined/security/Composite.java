package com.example.practice.pattern.structural.composite.defined.security;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> componentList = new ArrayList<>();

    @Override
    public void operation() {
        for(Component component:componentList){
            component.operation();
        }
    }

    public void add(Component component) {
        componentList.add(component);
    }

    public void remove(Component component) {
        componentList.remove(component);
    }

    public List<Component> getChilds() {
        return componentList;
    }
}
