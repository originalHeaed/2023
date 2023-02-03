package org.example.support;

import org.example.Exception.BeansException;
import org.example.config.BeanDefinition;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用 JDK 反射实现 bean 对象的实例化
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBean();
        try {
            /* 如果参数长度为 0，或者构造函数不存在：使用无参构造函数构建对象 */
            if (args == null || args.length == 0 || ctor == null) return clazz.newInstance();
            /* 使用指定的有参构造函数构建对象 */
            return ctor.newInstance(args);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate[" + clazz.getName() + "]", e);
        }
    }

}
