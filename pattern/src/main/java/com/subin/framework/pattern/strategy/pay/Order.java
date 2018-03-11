package com.subin.framework.pattern.strategy.pay;

import com.subin.framework.pattern.strategy.pay.payport.PayType;

/**
 * @author zhangsubin
 * @since 2018/3/11 下午11:59
 * description :
 */
public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid,String orderId,double amount){
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public PayState pay(PayType payType){
        return payType.get().pay(this.uid,this.amount);
    }
}
