package com.subin.framework.pattern.strategy.pay.payport;

import com.subin.framework.pattern.strategy.pay.PayState;

/**
 * @author zhangsubin
 * @since 2018/3/11 下午11:52
 * description :
 */
public class AliPay implements Payment{
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用支付宝");
        System.out.println("查询账户余额，开始扣款");
        return new PayState(200,"支付成功",amount);
    }
}
