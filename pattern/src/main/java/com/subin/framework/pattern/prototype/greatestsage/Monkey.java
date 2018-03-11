package com.subin.framework.pattern.prototype.greatestsage;

import java.util.Date;

/**
 * @author: subiin
 * @date: 2018/2/4 下午3:24
 * @description: 猴子
 */
public class Monkey {

    protected int height;

    protected int weight;

    protected Date birthday;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
