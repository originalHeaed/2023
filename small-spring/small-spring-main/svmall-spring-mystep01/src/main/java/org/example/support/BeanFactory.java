package org.example.support;

import org.example.Exception.BeansException;

/**
 * beanfactory 接口
 */
public interface BeanFactory {
    /**
     * 根据 bean 的 name 从工厂中获取 bean 对象
     * @param beanName
     * @return
     */
    Object getBean(String beanName) throws BeansException;
}
