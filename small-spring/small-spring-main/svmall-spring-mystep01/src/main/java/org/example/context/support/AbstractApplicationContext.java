package org.example.context.support;

import org.example.Exception.BeansException;
import org.example.context.ConfigurableApplicationContext;
import org.example.io.DefaultResourceLoader;
import org.example.support.extendInterface.BeanFactoryPostProcessor;
import org.example.support.extendInterface.BeanPostProcessor;
import org.example.support.instantiation.getBeanDefinition.ConfigurableListableBeanFactory;

import java.util.Map;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void refresh() throws BeansException {
        /* 1. 刷新或创建 BeanFactory，然后加载 BeanDefinition */
        /* 2. 执行 BeanFactoryPostProcessor 方法 */
        /* 3. 注册 BeanPostProcessor */
        /* 4. 将单例对象进行实例化 */

    }

    /**
     * 创建或刷新 BeanFactory
     */
    protected abstract void refreshBeanFactory() throws BeansException;

    /**
     * 获取 BeanFactory
     */
    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * 在将 BeanDefinition 注入 ioc 中之后，执行 BeanFactoryPostProcessor（提供外部一个修改内部 BeanDefinition 的接口）
     */
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, BeanFactoryPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beansOfType.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    /**
     * 将实现 BeanPostProcessor 接口的 bean 筛选然后添加
     * @param beanFactory
     * @throws BeansException
     */
    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, BeanPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beansOfType.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return getBeanFactory().getBean(beanName, args);
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    /**
     *
     * @param type
     * @return
     * @param <T>
     * @throws BeansException
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }
}
