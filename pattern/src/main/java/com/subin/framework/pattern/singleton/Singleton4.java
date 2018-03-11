package com.subin.framework.pattern.singleton;

/**
 * @author: subiin
 * @date: 2018/2/4 下午6:59
 * @description: 懒汉式（静态内部类）
 * 既解决了安全问题，又解决了性能问题
 */
public class Singleton4 {

    //1、先声明一个静态内部类
    //private 私有的保证别人不能修改
    //static 保证全局唯一
    private static class LazyHolder {
        //final 为了防止内部误操作，代理模式，GgLib的代理模式
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    //2、将默认构造方法私有化
    private Singleton4() {}

    //3、同样提供静态方法获取实例
    //final 确保别人不能覆盖
    public static final Singleton4 getInstance() {

        //方法中的逻辑，是要在用户调用的时候才开始执行的
        //方法中实现的逻辑需要分配内存，也是调用时才分配的
        return LazyHolder.INSTANCE;
    }
}
