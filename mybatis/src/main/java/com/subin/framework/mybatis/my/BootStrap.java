package com.subin.framework.mybatis.my;

import com.subin.framework.mybatis.beans.Test;

/**
 * @author: subiin
 * @date: 2018/2/28 下午9:09
 * @description:
 */
public class BootStrap {
    public static void start() {
        MySqlSession sqlSession = new MySqlSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(1);
        System.out.println(test);
    }

    public static void main(String[] args) {
        start();
    }
}
