package com.example.practice.java8.reflect;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectTest {
    public static void main2(String[] args) {
//        JSONObject jsonObject = JSON.parseObject("{'decimal':'100','str':'101','date':'2021/10/21'" +
//                ",'along':'102','integer':'103','integer2':'104','aBoolean':'true','strList':['12','123']}");

        Map<String ,Object> source = new HashMap<>();
        source.put("decimal","100");
        source.put("str","101");
        source.put("date","2021/10/21");
        source.put("along","102");
        source.put("integer","103");
        source.put("integer2","safda11");
        source.put("aBoolean","true");
        source.put("strList",new String[]{"12","123"});
//        source.put("strList","[12,123]");
//        String jsonStr= JSON.toJSONString(source);
//        System.out.println(jsonStr);
//        JSONObject jsonObject = JSON.parseObject(jsonStr);
//
//        Test test = JSON.toJavaObject(jsonObject,Test.class);

        Test test = new Test();
        BeanUtil.copyProperties(source,test, CopyOptions.create().setIgnoreNullValue(true));

        System.out.println(test);
    }

    public static void main3(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Map<String ,Object> source = new HashMap<>();
        source.put("decimal","100");
        source.put("str","101");
        source.put("date","2021/10/21");
        source.put("along","102");
        source.put("integer","103");
//        source.put("integer2","104");
        source.put("aBoolean","true");
//        source.put("strList","[12,123]");
        Test test = new Test();

        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(Test.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor property : properties){
            if(source.containsKey(property.getName())){
                Object value = source.get(property.getName());
                Method method = property.getWriteMethod();

                Class cls = method.getParameterTypes()[0];
//                if(cls.isPrimitive()){
//                    method.invoke(test,value);
//                }else{
                    Constructor<Class> constructor = null;
                    try {
                            constructor = cls.getConstructor(String.class);
                    } catch (NoSuchMethodException e) {
                        continue;
                    }
                    method.invoke(test,constructor.newInstance(value));
//                }
            }
        }
        System.out.println(test);
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        LocalDate localDate = LocalDate.of(2021,11,26);
//        Date date = (Date)loc;
        Map<String ,Object> source = new HashMap<>();
        source.put("decimal",new BigDecimal(100));
        source.put("str","101");
        source.put("date", new Date());
        source.put("localDate", LocalDate.of(2021,11,26));
        source.put("along",102L);
        source.put("integer",103);
//        source.put("integer2","104");
        source.put("aBoolean",true);
//        source.put("strList","[12,123]");
        Test test = new Test();

        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(Test.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor property : properties){
            if(source.containsKey(property.getName())){
                Object value = source.get(property.getName());
                Method method = property.getWriteMethod();

                Class cls = method.getParameterTypes()[0];
                method.invoke(test,value);
//                }
            }
        }
        System.out.println(test);
    }
    private static class Test{

        private BigDecimal decimal;
        private String str;
        private Date date;
        private LocalDate localDate;
        private Long along;
        private Integer integer ;
        private int integer2 ;
        private Boolean aBoolean;
        private List<String> strList;

        public BigDecimal getDecimal() {
            return decimal;
        }

        public void setDecimal(BigDecimal decimal) {
            this.decimal = decimal;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Long getAlong() {
            return along;
        }

        public void setAlong(Long along) {
            this.along = along;
        }

        public Integer getInteger() {
            return integer;
        }

        public void setInteger(Integer integer) {
            this.integer = integer;
        }

        public Boolean getaBoolean() {
            return aBoolean;
        }

        public int getInteger2() {
            return integer2;
        }

        public void setInteger2(int integer2) {
            this.integer2 = integer2;
        }

        public void setaBoolean(Boolean aBoolean) {
            this.aBoolean = aBoolean;
        }

        public List<String> getStrList() {
            return strList;
        }

        public void setStrList(List<String> strList) {
            this.strList = strList;
        }

        public LocalDate getLocalDate() {
            return localDate;
        }

        public void setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
        }
    }
}
