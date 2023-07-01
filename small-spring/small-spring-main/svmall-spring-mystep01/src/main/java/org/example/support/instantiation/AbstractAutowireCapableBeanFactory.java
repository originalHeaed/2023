package org.example.support.instantiation;

import cn.hutool.core.bean.BeanUtil;
import org.example.Exception.BeansException;
import org.example.config.BeanDefinition;
import org.example.config.BeanReference;
import org.example.config.PropertyValue;

import java.lang.reflect.Constructor;

/**
 * 提供抽象自动装配的 BeanFactory
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    /**
     * bean 对象实例化的策略（默认使用 JDK 反射进行实例化）
     */
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        /* 1.实例化 bean */
        try {
            bean = createBeanInstance(beanDefinition, args);
            applyPropertyValues(bean, beanDefinition, beanName);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        /* 2.将 bean 对象加入单例容器中 */
        addSingletonBean(beanName, bean);
        return bean;
    }

    /**
     * 提供可以被子类重写的创建 bean 实例方法
     * @param beanDefinition
     * @param args
     * @return
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, Object[] args) throws BeansException {
        /* 特殊情况判断(直接使用无参） */
        if (args == null || args.length == 0) return getInstantiationStrategy().instantiate(beanDefinition, null, null);
        /* 根据入参 args 获取构造函数 */
        Constructor[] declaredConstructor = beanDefinition.getBeanClass().getDeclaredConstructors();
        for (Constructor ctor: declaredConstructor) {
            /* todo: 这里的判断有问题，不能仅仅使用参数长度来进行判断 */
            if (ctor.getParameterTypes().length == args.length) {
                return getInstantiationStrategy().instantiate(beanDefinition, ctor, args);
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, null, args);
    }

    /**
     * 为 bean 对象中的属性赋值
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition, String beanName) throws BeansException {
        PropertyValue[] propertyValues = beanDefinition.getPropertyValues().getPropertyValues();
        try {
            for (PropertyValue pv : propertyValues) {
                Object value = pv.getValue();
                /* 该 bean 依赖另一个 bean */
                if (value instanceof BeanReference) {
                    value = getBean(((BeanReference) value).getBeanName()); // todo: 这里直接使用无参的也有问题
                }
                BeanUtil.setFieldValue(bean, pv.getName(), value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values:" + beanName, e);
        }
    }

    /**
     * 设置 class 实例化策略
     * @param instantiationStrategy
     */
    protected void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    private InstantiationStrategy getInstantiationStrategy() {
        return this.instantiationStrategy;
    }
}
