package org.example.support;

import org.example.Exception.BeansException;
import org.example.config.BeanDefinition;

/**
 * 通用抽象的 BeanFactory
 */
public abstract class AbstractBeanFactory extends AbstractDefaultSingletonBeanRegister implements BeanFactory{
    @Override
    public Object getBean(String beanName) throws BeansException {
        /* 1.缓存中是否存在 */
        Object o = getSingletonBean(beanName);
        if (o != null) return o;
        /* 2.如果缓存中不存在，则创建对象 */
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    /**
     * 获取 BeanDefintion 对象
     * @param beanName
     * @return
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 根据 BeanDefinition 创建对象
     * @param beanName
     * @param beanDefinition
     * @return
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);
}
