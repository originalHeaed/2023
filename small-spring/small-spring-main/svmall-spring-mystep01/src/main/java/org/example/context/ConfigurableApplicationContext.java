package org.example.context;

import org.example.Exception.BeansException;

/**
 * 提供刷新 spring ioc 容器方法的接口
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新 ioc 容器
     */
    void refresh() throws BeansException;
}
