package com.subin.framework.ioc.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.subin.framework.ioc.bean.BeanDefinition;
import com.subin.framework.ioc.utils.JsonUtils;

import java.io.InputStream;
import java.util.List;

/**
 * @author: subin
 * @date: 2018/1/14 上午11:50
 * @description:
 */
public class JsonApplicationContext extends BeanFactoryImpl {

    private String fileName;

    public JsonApplicationContext(String fileName) {
        this.fileName = fileName;
    }

    public void init() {
        loadFile();
    }

    private void loadFile() {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        List<BeanDefinition> beanDefinitions = JsonUtils.readValue(is, new TypeReference<List<BeanDefinition>>(){});
        if (beanDefinitions != null && !beanDefinitions.isEmpty()) {
            for (BeanDefinition beanDefinition : beanDefinitions) {
                registerBean(beanDefinition.getName(), beanDefinition);
            }
        }
    }
}
