package com.subin.framework.pattern.prototype.simple;

import java.util.ArrayList;

/**
 * @author: subiin
 * @date: 2018/2/4 下午3:18
 * @description:
 */
public class ConcretePrototype implements Cloneable {

    private int age;

    private String name;

    public ArrayList<String> list = new ArrayList<>();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ConcretePrototype prototype;

        prototype = (ConcretePrototype) super.clone();
        prototype.list = (ArrayList<String>) list.clone();

        return prototype;
//        return super.clone();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
