package org.example.support.register;

/**
 * 单例 BeanFactory
 */
public interface SingletonBeanRegistry {
    /**
     * 单例 bean 的获取
     * @param beanName
     * @return
     */
    Object getSingletonBean(String beanName);
}
