package org.example.support.register;

import org.example.support.register.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认单例 bean 注册抽象类
 */
public abstract class AbstractDefaultSingletonBeanRegister implements SingletonBeanRegistry {
    /**
     * 存放单例的 bean 容器
     */
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    /**
     * 从单例容器中获取 bean 对象
     * @param beanName
     * @return
     */
    @Override
    public Object getSingletonBean(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 向 singleton 容器中添加单例对象
     * @param beanName
     * @param singletonObject
     */
    protected void addSingletonBean(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
