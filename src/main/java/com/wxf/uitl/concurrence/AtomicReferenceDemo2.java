package com.wxf.uitl.concurrence;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by wxf on 2018/2/27.
 */
public class AtomicReferenceDemo2 {
    public static AtomicReference<User> atomicReference = new AtomicReference<User>();

    public static void main(String[] args) {
        User user = new User("wxf",25);
        atomicReference.set(user);
        User updateUser = new User("慈悲",26);
        atomicReference.compareAndSet(user,updateUser);
        System.out.println(atomicReference.get().toString());
    }
    static class User {
        public String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
