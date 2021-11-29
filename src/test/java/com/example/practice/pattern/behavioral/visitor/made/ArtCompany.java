package com.example.practice.pattern.behavioral.visitor.made;

// 具体访问者 ： 艺术公司
public class ArtCompany implements Company{
    @Override
    public String create(Paper paper) {
        return "《艺术入门书籍》";
    }

    @Override
    public String create(Cuprum cuprum) {
        return "十八铜人像";
    }
}
