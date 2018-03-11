package com.subin.framework.pattern.strategy.pay.payport;

import com.subin.framework.pattern.strategy.pay.PayState;

/**
 * @author zhangsubin
 * @since 2018/3/11 下午11:57
 * description :
 */
public class WechatPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用微信支付");
        System.out.println("直接从微信红包扣款");
        return new PayState(200,"支付成功",amount);
    }
}
