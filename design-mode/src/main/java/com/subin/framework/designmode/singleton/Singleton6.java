package com.subin.framework.designmode.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: subiin
 * @date: 2018/2/4 下午7:06
 * @description: 类似 Spring 里面的方法，将类名注册，下次从里边直接获取
 */
public class Singleton6 {

    private static Map<String, Singleton6> map = new HashMap<>();

    static {
        Singleton6 single = new Singleton6();
        map.put(single.getClass().getName(), single);
    }

    protected Singleton6() {}

    //静态方法工厂，返回此类唯一的实例
    public static Singleton6 getInstance(String name) {
        if (name == null) {
            name = Singleton6.class.getName();
        }
        if (map.get(name) == null) {
            try {
                map.put(name, (Singleton6) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
}
