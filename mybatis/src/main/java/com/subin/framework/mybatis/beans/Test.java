package com.subin.framework.mybatis.beans;

import lombok.Data;

/**
 * @author: subiin
 * @date: 2018/2/28 下午9:00
 * @description:
 */
@Data
public class Test {
    private Integer id;

    private Integer nums;

    private String name;

    public Test() {
    }

    public Test(Integer id, Integer nums, String name) {
        this.id = id;
        this.nums = nums;
        this.name = name;
    }
}
