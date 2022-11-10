package com.example.practice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ReflectionUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;

public class ClassTest {
    public static void main(String[] args) throws IntrospectionException, IllegalAccessException {
        DemoClass demoClass = DemoClass.builder().longField(111L).build();
        Object obj = demoClass;
        Field declaredField = ReflectionUtils.findField(obj.getClass(), "longField");
        declaredField.setAccessible(true);
        Object value = null;
        value = declaredField.get(obj);

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

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class DemoClass {
        private Long longField;
        private String stringField;
        private Date dateField;
        private BigDecimal bigDecimalField;
    }

}
