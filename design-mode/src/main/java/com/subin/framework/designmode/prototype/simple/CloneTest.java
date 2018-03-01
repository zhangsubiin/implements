package com.subin.framework.designmode.prototype.simple;

/**
 * @author: subiin
 * @date: 2018/2/4 下午3:20
 * @description:
 */
public class CloneTest {

    public static void main(String[] args) {


        ConcretePrototype cp = new ConcretePrototype();
        cp.setAge(18);
        cp.setName("Tom");
        cp.list.add("James");

        try {
            ConcretePrototype copy = (ConcretePrototype) cp.clone();

            System.out.println(cp.list == copy.list);

            System.out.println(copy.getAge());
            System.out.println(copy.getName());
            System.out.println(copy.list.size());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
