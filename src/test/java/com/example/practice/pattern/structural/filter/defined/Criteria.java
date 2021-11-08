package com.example.practice.pattern.structural.filter.defined;

import java.util.List;

public interface Criteria {

    public List<Person> filter(List<Person> personList);
}
