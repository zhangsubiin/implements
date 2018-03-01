package com.subin.framework.ioc.entity;

/**
 * @author: subiin
 * @date: 2018/1/14 下午12:00
 * @description:
 */
public class Robot {
    private Hand hand;
    private Mouth mouth;

    public void show() {
        hand.waveHand();
        mouth.speak();
    }
}
