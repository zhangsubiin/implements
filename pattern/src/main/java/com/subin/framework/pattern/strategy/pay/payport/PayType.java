package com.subin.framework.pattern.strategy.pay.payport;

/**
 * @author zhangsubin
 * @since 2018/3/11 下午11:58
 * description :
 */
public enum PayType {
    ALI_PAY(new AliPay()),
    WECHAT_PAY(new WechatPay()),
    JD_PAY(new JDPay());

    private Payment payment;

    PayType(Payment payment){
        this.payment = payment;
    }

    public Payment get(){ return  this.payment;}
}
