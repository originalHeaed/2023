package org.example.support.reader;

import cn.hutool.core.lang.Assert;
import org.example.io.DefaultResourceLoader;
import org.example.io.ResourceLoader;
import org.example.support.BeanDefinitionRegister;

/**
 * 抽象类
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    /**
     * 存储 bean 的容器
     */
    private final BeanDefinitionRegister beanDefinitionRegister;

    /**
     * 加载资源的工具
     */
    private final ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegister beanDefinitionRegister) {
        this(beanDefinitionRegister, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegister beanDefinitionRegister, ResourceLoader resourceLoader) {
        Assert.notNull(beanDefinitionRegister, "Bean Definition Register cannot be null");
        Assert.notNull(resourceLoader, "Resource loader cannot be null");
        this.beanDefinitionRegister = beanDefinitionRegister;
        this.resourceLoader = resourceLoader;
    }

    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }

    public BeanDefinitionRegister getBeanDefinitionRegister() {
        return this.beanDefinitionRegister;
    }
}
