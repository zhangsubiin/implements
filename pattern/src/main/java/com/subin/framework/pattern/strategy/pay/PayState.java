package com.subin.framework.pattern.strategy.pay;

/**
 * @author zhangsubin
 * @since 2018/3/11 下午11:52
 * description :
 */
public class PayState {
    private int code;
    private Object data;
    private String msg;

    public PayState(int code, String msg,Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "PayState{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
