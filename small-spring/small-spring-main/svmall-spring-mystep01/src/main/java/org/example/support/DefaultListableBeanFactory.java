package org.example.support;

import org.example.Exception.BeansException;
import org.example.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegister{
    /**
     * 存放 beanName-BeanDefinition对象 的键值对
     */
    private Map<String, BeanDefinition> map = new ConcurrentHashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = map.get(beanName);
        if (beanDefinition == null) throw new BeansException("no bean named：" + beanName + "is defined");
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        map.put(beanName, beanDefinition);
    }

    @Override
    public boolean containBeanDefinition(String beanName) {
        return map.containsKey(beanName);
    }
}
