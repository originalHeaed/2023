package org.example.support;

import org.example.Exception.BeansException;
import org.example.config.BeanDefinition;

/**
 * 提供抽象自动装配的 BeanFactory
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        /* 1.实例化 bean */
        try {
            bean = beanDefinition.getBean().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            new BeansException("Instantiation of bean failed", e);
        }
        /* 2.将 bean 对象加入单例容器中 */
        addSingletonBean(beanName, bean);
        return bean;
    }
}
