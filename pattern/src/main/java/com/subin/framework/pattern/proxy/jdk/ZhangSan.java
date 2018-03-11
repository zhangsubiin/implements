package com.subin.framework.pattern.proxy.jdk;

/**
 * @author: subiin
 * @date: 2018/2/3 下午1:46
 * @description:
 */
public class ZhangSan implements Person {

    private String sex = "男";
    private String name = "张三";

    @Override
    public void findLove() {
        System.out.println("我叫张三");
        System.out.println("白富美");
        System.out.println("有房有车");
        System.out.println("身高170，体重50Kg");
    }

//    @Override
    public String getSex() {
        return sex;
    }

//    @Override
    public String getName() {
        return name;
    }
}
