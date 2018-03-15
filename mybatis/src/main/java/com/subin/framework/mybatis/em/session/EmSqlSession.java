package com.subin.framework.mybatis.em.session;

import com.subin.framework.mybatis.em.config.EmConfiguration;
import com.subin.framework.mybatis.em.config.EmMapperRegistory;
import com.subin.framework.mybatis.em.executor.Executor;
import com.subin.framework.mybatis.em.mapper.EmMapperProxy;

import java.lang.reflect.Proxy;

/**
 * TODO description:
 *
 * @author zhangsubin
 * @since 2018/3/15 下午11:41
 */
public class EmSqlSession {
    private EmConfiguration emConfiguration;
    private Executor executor;

    public EmConfiguration getEmConfiguration() {
        return emConfiguration;
    }

    public EmSqlSession(EmConfiguration emConfiguration, Executor executor) {
        this.emConfiguration = emConfiguration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz},new EmMapperProxy<>(this,clazz));
    }

    public <T> T selectOne(EmMapperRegistory.MapperData mapperData, Object parameter) throws Exception {
        return executor.query(mapperData, parameter);
    }
}
