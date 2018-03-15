package com.subin.framework.mybatis.em.mapper;

import com.subin.framework.mybatis.em.session.EmSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * TODO description:
 *
 * @author zhangsubin
 * @since 2018/3/15 下午11:46
 */
public class EmMapperProxy<T> implements InvocationHandler {
    private final EmSqlSession sqlSession;
    private final Class<T> mappperInterface;

    public EmMapperProxy(EmSqlSession sqlSession, Class<T> mappperInterface) {
        this.sqlSession = sqlSession;
        this.mappperInterface = mappperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
