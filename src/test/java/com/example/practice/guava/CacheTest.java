package com.example.practice.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * guava缓存功能
 *      相比spring的ConcurrentMapCache，guava的LocalCache可以设置过期时间、最大容量等
 * @author twp
 * @date 2021/01/17
 */
public class CacheTest {

    public static void main(String args[]){
        // guava cache 1：
        testGuavaCacheSimple();
        // guava cache 2：
        testGuavaCacheUtil();

        // springframework cache 1：
        testSpringCacheSimple();
    }

    private static void testSpringCacheSimple() {
    }

    /**
     * 产品上进阶用法
     */
    private static void testGuavaCacheUtil() {
        ImportCache.get("100",()->getFromDatabase("100"));
        ImportCache.get("100",()->getFromDatabase("100"));
    }

    private static class ImportCache {
        private static Cache<String,Object> CACHE = CacheBuilder.newBuilder().concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .initialCapacity(5000).maximumSize(50000).expireAfterAccess(30, TimeUnit.MINUTES).build();

        public static  Object get(String key, Callable callable){
            try {
                return CACHE.get(key,callable);
            } catch (ExecutionException e) {
                System.out.println("ExecutionException");
                e.printStackTrace();
                return null;
            } catch (CacheLoader.InvalidCacheLoadException e2){
                return null;
            }
        }

        public static void invalidate(String key){
            CACHE.invalidate(key);
        }
    }

    /**
     * 简单用法
     */
    private static void testGuavaCacheSimple() {
        //create a cache for employees based on their employee id
        LoadingCache employeeCache =
                CacheBuilder.newBuilder()
                        .maximumSize(100) // maximum 100 records can be cached
                        .expireAfterAccess(30, TimeUnit.MINUTES) // cache will expire after 30 minutes of access
                        .build(new CacheLoader<String,Employee>(){ // build the cacheloader
                            @Override
                            public Employee load(String empId) throws Exception {
                                //make the expensive call
                                return getFromDatabase(empId);
                            }
                        });

        try {
            //on first invocation, cache will be populated with corresponding
            //employee record
            System.out.println("Invocation #1");
            System.out.println(employeeCache.get("100"));
            System.out.println(employeeCache.get("103"));
            System.out.println(employeeCache.get("110"));

            employeeCache.invalidate("100");
            //second invocation, data will be returned from cache
            System.out.println("Invocation #2");
            System.out.println(employeeCache.get("100"));
            System.out.println(employeeCache.get("103"));
            System.out.println(employeeCache.get("110"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static Employee getFromDatabase(String empId){
        Employee e1 = new Employee("Mahesh", "Finance", "100");
        Employee e2 = new Employee("Rohan", "IT", "103");
        Employee e3 = new Employee("Sohan", "Admin", "110");

        Map<String,Employee> database = new HashMap();
        database.put("100", e1);
        database.put("103", e2);
        database.put("110", e3);
        System.out.println("Database hit for" + empId);
        return database.get(empId);
    }


}
