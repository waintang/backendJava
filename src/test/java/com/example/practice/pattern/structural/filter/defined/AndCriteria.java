package com.example.practice.pattern.structural.filter.defined;

import java.util.List;

public class AndCriteria implements Criteria {

    private Criteria criterias;
    private Criteria otherCriterias;

    public AndCriteria(Criteria criteria,Criteria otherCriterias){
        this.criterias = criteria;
        this.otherCriterias = otherCriterias;
    }

    @Override
    public List<Person> filter(List<Person> personList) {
        personList = criterias.filter(personList);
        return otherCriterias.filter(personList);
    }
}
