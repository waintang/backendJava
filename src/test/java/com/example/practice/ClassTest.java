package com.example.practice;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;

public class ClassTest {
    public static void main(String[] args) throws IntrospectionException {
        DemoClass demoClass = new DemoClass();

        BeanInfo beanInfo = Introspector.getBeanInfo(demoClass.getClass());
        PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor prop: properties) {
            String key = prop.getName();
            System.out.println("getName:"+prop.getName());
            System.out.println("propertyType:"+prop.getPropertyType());

            if(Long.class == prop.getPropertyType()){
                System.out.println("这是Long字段");
            }
        }




        Field[] fields = DemoClass.class.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName());
            System.out.println(field.getType());
        }
    }

    @Data
    @NoArgsConstructor
    static class DemoClass {
        private Long longField;
        private String stringField;
        private Date dateField;
        private BigDecimal bigDecimalField;
    }

}
