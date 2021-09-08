package com.example.practice.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description：测试java8，stream相关的东西
 * @author：tavion
 * @date：2021/4/27 16:15
 */
public class StreamTest {

    public static void main(String args[]){
        System.out.println(Stream.of(2,3,4,5).map((x)->x<4?x+1:x).distinct().reduce(1,(a,b)->a*b));

        List<String> strList = new ArrayList<>();
        strList.add(null);
        strList.add(null);
        strList.add(null);
//        strList.add("t");
//        strList.add("w");
//        strList.add("p");
//        strList.add("t");
        System.out.println(strList);
        Map<String,Long> nameCountMap = strList.stream().filter(item-> !StringUtils.isEmpty(item)).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(nameCountMap);
        nameCountMap.forEach((k,v)->{
            System.out.println(k + " " + v);
        });

        List<ProductCategoriesDTO> result = new ArrayList<>();
        result.add(new ProductCategoriesDTO(0L,null));
        result.add(new ProductCategoriesDTO(1L,0L));
        result.add(new ProductCategoriesDTO(2L,1L));
        result.add(new ProductCategoriesDTO(4L,3L));

        getWholeTree(result);
    }

    private static void getWholeTree(List<ProductCategoriesDTO> result){
        if(ObjectUtils.isEmpty(result)){
            return;
        }
        List<Long> categoryIds = result.stream().map(ProductCategoriesDTO::getProductCategoryId).distinct().filter(item->!ObjectUtils.isEmpty(item)).collect(Collectors.toList());
        // 所有父节点 是否已经 集齐
        List<Long> parentCategoryIds = result.stream().map(ProductCategoriesDTO::getParentCategoryId)
                .distinct().filter(item->!categoryIds.contains(item)).filter(item-> !ObjectUtils.isEmpty(item)).collect(Collectors.toList());

        if(ObjectUtils.isEmpty(parentCategoryIds)){
            return;
        }

        List<ProductCategoriesDTO> searchList = new ArrayList<>();
        searchList.add(new ProductCategoriesDTO(3L,2L));
        result.addAll(searchList);
        getWholeTree(result);
        return;
    }

    @Data
    @AllArgsConstructor
    private static class ProductCategoriesDTO {

        private Long productCategoryId;

        private Long parentCategoryId;

    }
}
