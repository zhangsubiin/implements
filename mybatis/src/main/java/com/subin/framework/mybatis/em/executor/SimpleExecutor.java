package com.subin.framework.mybatis.em.executor;

import com.subin.framework.mybatis.em.config.EmConfiguration;
import com.subin.framework.mybatis.em.config.EmMapperRegistory;
import com.subin.framework.mybatis.em.statement.StatementHandler;

/**
 * @author zhangsubin
 * @since 2018/3/14 上午12:02
 * description :
 */
public class SimpleExecutor implements Executor {

    private EmConfiguration configuration;

    public SimpleExecutor(EmConfiguration configuration) {
        this.configuration = configuration;
    }

    public EmConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(EmConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T query(EmMapperRegistory.MapperData mapperData, Object parameter) throws Exception {
        //初始化StatementHandler --> ParameterHandler --> ResultSetHandler
        StatementHandler handler = new StatementHandler(configuration);
        return (E) handler.query(mapperData, parameter);
    }
}
