package org.example.support.instantiation;

import org.example.Exception.BeansException;
import org.example.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例 bean 构造结构
 */
public interface InstantiationStrategy {
    /**
     * 实力话 bean 对象
     * @param beanDefinition
     * @param ctor
     * @param args
     * @return
     */
    Object instantiate(BeanDefinition beanDefinition, Constructor ctor, Object[] args) throws BeansException;
}
