package com.example.practice;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description：测试fastJson
 * @author：tavion
 * @date：2021/5/13 15:36
 */
public class FastjsonTest {
    public static void main(String args[]){
        String json = "[{'code':'pass'},{'code':null}]";
        JSONArray jsonArray222 = JSONObject.parseArray(json);
        System.out.println(jsonArray222);

        List jsonArray = JSONObject.parseArray(json);
        System.out.println(jsonArray);
        List<Employee> employees = new ArrayList<>();
        List<EmployeeEx> employeeExs = new ArrayList<>();
        // private的类，同类可调用
        EmployeeEx employeeEx1 = new EmployeeEx(1l,"n1","twp","twpen",0l,new Date());
        System.out.println(JSONObject.toJSONString(employeeEx1));
        EmployeeEx employeeEx2 = new EmployeeEx(2l,"n2","twp2","twp2en",0l,new Date());
        employeeExs.add(employeeEx1);
        employeeExs.add(employeeEx2);

        // list转jsonArray
        JSONArray array = JSONArray.parseArray(JSONObject.toJSONString(employeeExs));
        System.out.println(array.toJSONString());
        // jsonArray转list （JSONObject外包类创建 Employee类，需要Employee是public）
        employees = JSONObject.parseArray(array.toJSONString(), Employee.class);
        System.out.println(employees);
    }

    @Data
    @AllArgsConstructor
    public static class Employee{
        private Long employeeId;
        private String employeeNum;
        private String name;
        private String nameEn;
        private Long tenantId;
        private Date inSchoolDate;
    }
    @Data
    @AllArgsConstructor
    private static class EmployeeEx{
        private Long employeeId;
        private String employeeNum;
        private String name;
        private String nameEn;
        private Long tenantId;
        private Date inSchoolDate;
    }
}