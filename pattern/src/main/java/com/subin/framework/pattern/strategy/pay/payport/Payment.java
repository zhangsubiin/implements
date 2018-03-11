package com.subin.framework.pattern.strategy.pay.payport;

import com.subin.framework.pattern.strategy.pay.PayState;

/**
 * @author zhangsubin
 * @since 2018/3/11 下午11:52
 * description :
 */
public interface Payment {
    PayState pay(String uid, double amount);
}
