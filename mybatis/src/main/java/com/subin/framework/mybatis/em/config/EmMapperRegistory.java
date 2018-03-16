package com.subin.framework.mybatis.em.config;

import com.subin.framework.mybatis.beans.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangsubin
 * @since 2018/3/13 下午11:57
 * description :
 */
public class EmMapperRegistory {
    public static final Map<String, MapperData> methodSqlMapping = new HashMap<>();

    //使用 1. 在这里配置
    //2. Java Bean的属性名字要和数据库表的名字一致
    public void MapperRegistory() {
        methodSqlMapping.put("com.subin.framework.mybatis.my.TestMapper.selectByPrimaryKey",
                new MapperData("select * from test where id = %d",Test.class));
    }

    public class MapperData<T>{
        private String sql;
        private Class<T> type;

        public MapperData(String sql, Class<T> type) {
            this.sql = sql;
            this.type = type;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }

        public Class<T> getType() {
            return type;
        }

        public void setType(Class<T> type) {
            this.type = type;
        }

    }

    public MapperData get(String nameSpace) {
        return methodSqlMapping.get(nameSpace);
    }
}
