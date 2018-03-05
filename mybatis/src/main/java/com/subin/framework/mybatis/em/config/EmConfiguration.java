package com.subin.framework.mybatis.em.config;

import lombok.Data;

import java.io.IOException;

/**
 * @author: subiin
 * @date: 2018/3/5 下午11:41
 * @description:
 */
@Data
public class EmConfiguration {

    private String scanPath;

    private EmMapperRegistory mapperRegistory = new EmMapperRegistory();

    public EmConfiguration scanPath(String scanPath) {
        this.scanPath = scanPath;
        return this;
    }

    public void build() throws IOException {
        if (scanPath == null || scanPath.length() < 1) {
            throw new RuntimeException("scan path is required.");
        }
    }

    public static void main(String[] args) throws IOException{
        new EmConfiguration().scanPath("com/subin/framework/mybatis/em/config/mappers").build();
    }
}
