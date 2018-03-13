package com.subin.framework.mybatis.em.executor;

import com.subin.framework.mybatis.em.config.EmMapperRegistory;

/**
 * @author zhangsubin
 * @since 2018/3/14 上午12:01
 * description :
 */
public interface Executor {
    <T> T query(EmMapperRegistory.MapperData mapperData, Object parameter) throws Exception;
}
