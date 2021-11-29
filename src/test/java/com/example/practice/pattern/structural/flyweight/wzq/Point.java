package com.example.practice.pattern.structural.flyweight.wzq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Point {
    private int x;
    private int y;
}
