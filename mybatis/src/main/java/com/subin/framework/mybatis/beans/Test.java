package com.subin.framework.mybatis.beans;

import lombok.Data;

@Data
public class Test {
    private Integer id;

    private Integer nums;

    private String name;

    public Test(Integer id, Integer nums, String name) {
        this.id = id;
        this.nums = nums;
        this.name = name;
    }

    public Test() {
    }
}