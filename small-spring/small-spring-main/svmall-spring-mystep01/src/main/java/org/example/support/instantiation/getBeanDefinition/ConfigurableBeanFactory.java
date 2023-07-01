package org.example.support.instantiation.getBeanDefinition;

import org.example.support.extendInterface.BeanPostProcessor;
import org.example.support.register.SingletonBeanRegistry;

/**
 * 用于维护 BeanPostProcessor 对象
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
