package org.example.support.extendInterface;

import org.example.Exception.BeansException;

/**
 * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，
 * 提供修改 BeanDefinition 属性的机制
 */
public interface BeanPostProcessor {
    /**
     * 初始化前前置处理
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 初始化前后置处理
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
