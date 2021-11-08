package com.example.practice.pattern.structural.filter.defined;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaMale implements Criteria {
    @Override
    public List<Person> filter(List<Person> personList) {
        return personList.stream().filter(item->item.getGender()=="Male").collect(Collectors.toList());
    }
}
