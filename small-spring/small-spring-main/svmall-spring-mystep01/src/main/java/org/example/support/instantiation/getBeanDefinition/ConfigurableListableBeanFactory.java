package org.example.support.instantiation.getBeanDefinition;

import org.example.Exception.BeansException;
import org.example.config.BeanDefinition;
import org.example.support.instantiation.ListableBeanFactory;

/**
 * todo 暂时不知道这个是干什么的
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
