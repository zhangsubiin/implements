package com.subin.framework.designmode.proxy.jdk;

import com.subin.framework.designmode.proxy.custom.MyMeipo;

/**
 * @author: subiin
 * @date: 2018/2/3 下午1:50
 * @description:
 */
public class TestFindLove {

    public static void main(String[] args) {
//        new ZhangSan().findLove();

        try {
//            Person obj = (Person) new Meipo().getInstance(new ZhangSan());
//            System.out.println("代理对象：" + obj.getClass());
//            obj.findLove();

//            //获取字节码内容
//            byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
//            FileOutputStream out = new FileOutputStream("/Users/emma/Desktop/my_projects/realization4designMode/$Proxy0.class");
//            out.write(data);
//            out.flush();
//            out.close();

            Person obj = (Person) new MyMeipo().getInstance(new ZhangSan());
            System.out.println("代理对象：" + obj.getClass());
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
