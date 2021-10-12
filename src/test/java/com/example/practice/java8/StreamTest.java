package com.example.practice.java8;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;
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
        objectToLongList();
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
        HashMap hashMap = new HashMap();


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

    private  static List<Long> objectToLongList(){
        List<Long> allRoleIds = null;
        List<Long> siteRoleIds = null;
        List<Long> tenantRoleIds = null;
        JSONArray jsonArray = JSONArray.parseArray("[{\"id\":1,\"name\":\"平台管理员\",\"code\":\"role/site/default/administrator\",\"level\":\"site\",\"tenantId\":0,\"parentRoleAssignLevel\":\"organization\",\"parentRoleAssignLevelValue\":0,\"tenantName\":\"HZERO平台\",\"roleHierarchy\":0,\"memberRoleId\":104,\"_token\":\"keUs24wdEJx8Lgl9KbyHaW3Pyg8anglhvllGobP5iHW0NgH/wDpB0MlFrHHZYraa\",\"defaultRole\":false},{\"id\":2,\"name\":\"租户管理员\",\"code\":\"role/organization/default/administrator\",\"level\":\"organization\",\"tenantId\":0,\"parentRoleAssignLevel\":\"organization\",\"parentRoleAssignLevelValue\":0,\"tenantName\":\"HZERO平台\",\"roleHierarchy\":0,\"memberRoleId\":303,\"_token\":\"keUs24wdEJx8Lgl9KbyHaW3Pyg8anglhvllGobP5iHU5yJA0k7bL6YoBFnKEvYAC\",\"defaultRole\":false},{\"id\":12,\"name\":\"租户管理员\",\"code\":\"administrator\",\"level\":\"organization\",\"tenantId\":1,\"parentRoleAssignLevel\":\"organization\",\"parentRoleAssignLevelValue\":0,\"tenantName\":\"租户\",\"roleHierarchy\":0,\"memberRoleId\":283,\"_token\":\"keUs24wdEJx8Lgl9KbyHaW3Pyg8anglhvllGobP5iHWT9N1N0UGrwsggpZGp/pWI3ANaVi8Tczocyt/UTGgU2g==\",\"defaultRole\":false}]");
        allRoleIds = Arrays.stream(jsonArray.toArray()).map(item->{JSONObject jsonObject = (JSONObject)item;return jsonObject.getLong("id");}).collect(Collectors.toList());
        siteRoleIds = Arrays.stream(jsonArray.toArray()).filter(item->{JSONObject jsonObject = (JSONObject)item;return jsonObject.getLong("tenantId")!=0L;}).map(item->{JSONObject jsonObject = (JSONObject)item;return jsonObject.getLong("id");}).collect(Collectors.toList());
        tenantRoleIds = Arrays.stream(jsonArray.toArray()).filter(item->{JSONObject jsonObject = (JSONObject)item;return jsonObject.getLong("tenantId")==0L;}).map(item->{JSONObject jsonObject = (JSONObject)item;return jsonObject.getLong("id");}).collect(Collectors.toList());
        Optional<Long> min = Arrays.stream(jsonArray.toArray()).map(item->{JSONObject jsonObject = (JSONObject)item;return jsonObject.getLong("id");}).max(Long::compareTo);
        return tenantRoleIds;
    }

    @Data
    @AllArgsConstructor
    private static class ProductCategoriesDTO {

        private Long productCategoryId;

        private Long parentCategoryId;

    }
}
