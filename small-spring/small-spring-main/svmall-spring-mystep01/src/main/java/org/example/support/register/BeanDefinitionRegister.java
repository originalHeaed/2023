package org.example.support.register;

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

    /**
     * 判断容器中是否存在指定 beanName 的 BeanDefinition
     * @param beanName
     * @return
     */
    boolean containBeanDefinition(String beanName);
}
