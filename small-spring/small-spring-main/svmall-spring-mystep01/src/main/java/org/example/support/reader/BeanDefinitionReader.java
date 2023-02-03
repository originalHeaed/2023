package org.example.support.reader;

import org.example.Exception.BeansException;
import org.example.io.Resource;

/**
 * 定义注册 beanDefinition 的行为
 */
public interface BeanDefinitionReader {
    /**
     * 从 resource 中获取 beanDefinition
     * @param resources
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 从指定的位置获取内容，然后加载 beanDefinition
     * @param location
     */
    void loadBeanDefinitions(String location) throws BeansException;
}
