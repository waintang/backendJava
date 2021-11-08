package com.example.practice.pattern.structural.filter.defined;

import java.util.ArrayList;
import java.util.List;

public class DefinedTest {
    public static void main(String[] args) {
        Person person1 = new Person("A","Mal2e","Single");
        Person person2 = new Person("B","Female","Married");
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);

        Criteria criteriaMale = new CriteriaMale();
//        personList = criteriaMale.filter(personList);
        Criteria criteriaSingle = new CriteriaSingle();
        Criteria andCriteria = new AndCriteria(criteriaMale,criteriaSingle);
        personList = andCriteria.filter(personList);

        personList.forEach(item->System.out.println(item.toString()));

    }
}
