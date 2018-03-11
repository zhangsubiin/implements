package com.subin.framework.pattern.prototype.greatestsage;

import java.io.Serializable;

/**
 * @author: subiin
 * @date: 2018/2/4 下午3:45
 * @description: 金箍棒
 */
public class GoldRingedStaff implements Serializable {

    private float height = 100;

    private float diameter = 10;

    public void grow() {
        this.diameter *= 2;
        this.height *= 2;
    }

    public void shrink() {
        this.diameter /= 2;
        this.height /= 2;
    }
}
