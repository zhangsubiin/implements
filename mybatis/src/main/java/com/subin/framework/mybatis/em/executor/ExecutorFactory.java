package com.subin.framework.mybatis.em.executor;

import com.subin.framework.mybatis.em.config.EmConfiguration;

/**
 * TODO description:
 *
 * @author zhangsubin
 * @since 2018/3/15 下午11:46
 */
public class ExecutorFactory {

    private static final String SIMPLE = "simple";


    public static SimpleExecutor DEFAULT(EmConfiguration configuration) {
        return get(SIMPLE, configuration);
    }

    public static SimpleExecutor get(String key, EmConfiguration configuration) {
        if (SIMPLE.equalsIgnoreCase(key)) {
            return new SimpleExecutor(configuration);
        }
        throw new RuntimeException("no executor found");
    }

    public enum ExecutorType {
        SIMPLE
    }
}
