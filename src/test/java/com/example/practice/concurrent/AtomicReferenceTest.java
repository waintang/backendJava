package com.example.practice.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @description：原子更新引用类型
 * @author：tavion
 * @date：2021/1/22 14:14
 */
public class AtomicReferenceTest {

    public static AtomicReference<User> userAtomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("conan",15);
        userAtomicReference.set(user);
        User updateUser = new User("Shinichi",17);
        userAtomicReference.compareAndSet(user,updateUser);
        System.out.println(userAtomicReference.get().getName());
        System.out.println(userAtomicReference.get().getOld());
    }

    static class User {
        private String name;
        private int old;

        public User(String name ,int old){
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setOld(int old) {
            this.old = old;
        }

        public int getOld() {
            return old;
        }
    }
}
