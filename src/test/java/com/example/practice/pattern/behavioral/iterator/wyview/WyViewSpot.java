package com.example.practice.pattern.behavioral.iterator.wyview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

// 0、定义景点对象
@Data
@AllArgsConstructor
@Builder
public class WyViewSpot {
    private String name ;
    private String introduce;
}
