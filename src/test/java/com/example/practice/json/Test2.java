package com.example.practice.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Test2<T>{
    private Boolean bool1;
    private Long testLong1;
    private List<InnerTest2> innerTest2s;
    private T test;

    @Data
    static class InnerTest2{
        private String innerStr1;
    }
}
