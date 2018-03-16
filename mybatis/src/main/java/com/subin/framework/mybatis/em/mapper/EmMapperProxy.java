package com.subin.framework.mybatis.em.mapper;

import com.subin.framework.mybatis.em.config.EmMapperRegistory;
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

    public  EmMapperProxy(EmSqlSession sqlSession, Class<T> mappperInterface) {
        this.sqlSession = sqlSession;
        this.mappperInterface = mappperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        EmMapperRegistory.MapperData mapperData = sqlSession.getEmConfiguration()
                .getMapperRegistory().get(method.getDeclaringClass().getName() + "." + method.getName());
        if (mapperData != null) {
            System.out.println(String.format("SQL [ %s ], parameter [%s] ", mapperData.getSql(), args[0]));
            return sqlSession.selectOne(mapperData, String.valueOf(args[0]));
        }
        return method.invoke(proxy, args);
    }
}
