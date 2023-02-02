package org.example.support;

import org.example.Exception.BeansException;
import org.example.config.BeanDefinition;

import java.awt.*;
import java.lang.reflect.Constructor;

/**
 * 提供抽象自动装配的 BeanFactory
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    /**
     * bean 对象实例化的策略
     */
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        /* 1.实例化 bean */
        try {
            bean = createBeanInstance(beanDefinition, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        /* 2.将 bean 对象加入单例容器中 */
        addSingletonBean(beanName, bean);
        return bean;
    }

    /**
     * 提供可以被子类重写的创建 bean 实例方法
     * @param beanDefinition
     * @param args
     * @return
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, Object[] args) throws BeansException {
        /* 特殊情况判断(直接使用无参） */
        if (args == null || args.length == 0) return instantiationStrategy.instantiate(beanDefinition, null, null);
        /* 根据入参 args 获取构造函数 */
        Constructor[] declaredConstructor = beanDefinition.getBean().getDeclaredConstructors();
        for (Constructor ctor: declaredConstructor) {
            if (ctor.getParameterTypes().length == args.length) {
                return instantiationStrategy.instantiate(beanDefinition, ctor, args);
            }
        }
        return instantiationStrategy.instantiate(beanDefinition, null, args);
    }
}
