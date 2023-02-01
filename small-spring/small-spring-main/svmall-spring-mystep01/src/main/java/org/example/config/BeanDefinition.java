package org.example.config;

/**
 * 用于存放 bean 的 class 字节码
 */
public class BeanDefinition {

    /**
     * 存储 bean 对象
     */
    private Class bean;

    /**
     * 构造函数
     */
    public BeanDefinition(Class bean) {
        this.bean = bean;
    }

    public Class getBean() {
        return bean;
    }
}
