package com.subin.framework.designmode.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @author: subiin
 * @date: 2018/2/4 下午7:55
 * @description:
 */
public class TestThread {

    public static void main(String[] args) {
        //启动100线程同时去抢CPU
        int count = 100;

        //发令枪，测试并发经常用到
        CountDownLatch latch = new CountDownLatch(count);

        //Set默认去重的，set本身是线程不安全的
        final Set<Singleton4> syncSet = Collections.synchronizedSet(new HashSet<>());

        for (int i = 0; i < count; i++) {
            new Thread(){
                @Override
                public void run() {
                    syncSet.add(Singleton4.getInstance());
                }
            }.start();

            latch.countDown();
        }

        try {
            latch.await();//等待所有线程全部完成，最终输出结果
            System.out.println(syncSet.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
