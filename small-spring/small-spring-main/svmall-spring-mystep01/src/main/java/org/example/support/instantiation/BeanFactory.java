package org.example.support.instantiation;

import org.example.Exception.BeansException;

/**
 * beanfactory 接口
 */
public interface BeanFactory {
    /**
     * 根据 bean 的 name 从工厂中获取 bean 对象
     */
    Object getBean(String beanName, Object... args) throws BeansException;

    /**
     * 仅支持获取无参 bean 实例
     */
    @Deprecated
    Object getBean(String beanName) throws BeansException;

    /**
     * 根据 name 和 类型获取对应的 bean 对象
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}