package com.example.practice.pattern.structural.composite.defined.pervious;

import java.util.List;

public interface Component {
    void operation();
    void add(Component component);
    void remove(Component component);
    List<Component> getChilds();
}
