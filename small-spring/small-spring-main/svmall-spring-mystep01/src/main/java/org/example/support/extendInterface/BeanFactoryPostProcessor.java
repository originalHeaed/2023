package org.example.support.extendInterface;

import org.example.Exception.BeansException;
import org.example.support.instantiation.getBeanDefinition.ConfigurableListableBeanFactory;

/**
 * 提供对 BeanDefinition 的修改接口
 */
public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
