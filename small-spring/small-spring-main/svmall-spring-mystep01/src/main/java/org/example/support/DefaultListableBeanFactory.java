package org.example.support;

import org.example.Exception.BeansException;
import org.example.config.BeanDefinition;
import org.example.support.instantiation.AbstractAutowireCapableBeanFactory;
import org.example.support.instantiation.getBeanDefinition.ConfigurableListableBeanFactory;
import org.example.support.register.BeanDefinitionRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用于存放 BeanDefinition 对象信息（内部使用 Map 实现）
 */
public abstract class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {
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

    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        for (Map.Entry<String, BeanDefinition> entry : map.entrySet()) {
            Class beanClass = entry.getValue().getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                result.put(entry.getKey(), (T) getBean(entry.getKey()));
            }

        }
        map.forEach((beanName, beanDefinition) -> {
        });
        return result;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return null;
    }
}
