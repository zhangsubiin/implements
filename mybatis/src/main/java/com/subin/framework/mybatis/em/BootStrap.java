package com.subin.framework.mybatis.em;

import com.subin.framework.mybatis.beans.Test;
import com.subin.framework.mybatis.em.config.EmConfiguration;
import com.subin.framework.mybatis.em.config.mappers.TestMapper;
import com.subin.framework.mybatis.em.executor.ExecutorFactory;
import com.subin.framework.mybatis.em.session.EmSqlSession;

import java.io.IOException;

/**
 * TODO description:
 *
 * @author zhangsubin
 * @since 2018/3/15 下午11:40
 */
public class BootStrap {

    public static void main(String[] args) throws IOException {
        start();
    }

    private static void start() throws IOException {
        EmConfiguration configuration = new EmConfiguration();
        configuration.setScanPath("com.gupaoedu.mybatis.gp.config.mappers");
        configuration.build();
        EmSqlSession sqlSession = new EmSqlSession(configuration, ExecutorFactory.DEFAULT(configuration));
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(1);
        System.out.println(test);
    }

}
