package com.subin.framework.mybatis.em.config.mappers;

import com.subin.framework.mybatis.beans.Test;

/**
 * @author: subiin
 * @date: 2018/3/5 下午11:40
 * @description:
 */
public interface TestMapper {
    Test selectByPrimaryKey(Integer userId);
}
