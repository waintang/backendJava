package com.example.practice.pattern.structural.filter.defined;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaSingle implements  Criteria {
    @Override
    public List<Person> filter(List<Person> personList) {
        return personList.stream().filter(item->item.getMaritalStatus()=="Single").collect(Collectors.toList());
    }
}
