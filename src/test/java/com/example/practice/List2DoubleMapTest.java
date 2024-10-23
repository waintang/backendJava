package com.example.practice;

import cn.hutool.core.util.StrUtil;

import java.util.*;
import java.util.stream.Collectors;

class Element {
    String keyword;
    String posgroup;
    int page;
    int ypos;

    public Element(String keyword, String posgroup, int page, int ypos) {
        this.keyword = keyword;
        this.posgroup = posgroup;
        this.page = page;
        this.ypos = ypos;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getPosgroup() {
        return posgroup;
    }

    public int getPage() {
        return page;
    }

    public int getYpos() {
        return ypos;
    }

    @Override
    public String toString() {
        return "Element{" +
                "keyword='" + keyword + '\'' +
                ", posgroup='" + posgroup + '\'' +
                ", page=" + page +
                ", ypos=" + ypos +
                '}';
    }
}

public class List2DoubleMapTest {
    public static void main(String[] args) {
        // 创建示例数据
        List<Element> elements = Arrays.asList(
                new Element("A", "group1", 1, 20),
                new Element("A", "", 1, 10),
                new Element("A", "group2", 2, 30),
                new Element("B", "group3", 1, 15),
                new Element("B", "", 2, 25)
        );

        // 转换为 Map<String, Map<Integer, Boolean>>
        Map<String, Map<Integer, Boolean>> resultMap = elements.stream()
                // 按 keyword 分组
                .collect(Collectors.groupingBy(
                        Element::getKeyword,
                        Collectors.collectingAndThen(
                                // 对每个 keyword 的元素进行排序
                                Collectors.toList(),
                                list -> {
                                    // 按 page 排序，同 page 再按 ypos 排序
                                    list.sort(Comparator.comparingInt(Element::getPage)
                                            .thenComparingInt(Element::getYpos));
                                    // 生成第二层 Map
                                    Map<Integer, Boolean> innerMap = new LinkedHashMap<>();
                                    for (int i = 0; i < list.size(); i++) {
                                        Element element = list.get(i);
                                        innerMap.put(i + 1, StrUtil.isNotBlank(element.getPosgroup()));
                                    }
                                    return innerMap;
                                }
                        )
                ));

        // 打印结果
        resultMap.forEach((keyword, map) -> {
            System.out.println("Keyword: " + keyword);
            map.forEach((index, posgroupPresent) -> {
                System.out.println("  Index: " + index + ", Posgroup Present: " + posgroupPresent);
            });
        });
    }
}
