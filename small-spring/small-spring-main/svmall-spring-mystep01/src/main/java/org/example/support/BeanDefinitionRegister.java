package org.example.support;

import org.example.config.BeanDefinition;

/**
 * 注册 bean 接口
 */
public interface BeanDefinitionRegister {
    /**
     * 将 bean 信息注册容器中
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
