package org.example.config;

/**
 * 用于存放 bean 的 class 字节码
 */
public class BeanDefinition {

    /**
     * bean 的 class 对象
     */
    private Class bean;

    /**
     * bean 对象中各个属性的值
     */
    private PropertyValues propertyValues = new PropertyValues();;

    /**
     * 构造函数
     */
    public BeanDefinition(Class bean, PropertyValues propertyValues) {
        this.bean = bean;
        if (propertyValues != null) this.propertyValues = propertyValues;
    }

    /**
     * 无属性赋值的 bean
     * @param bean
     */
    public BeanDefinition(Class bean) {
        this.bean = bean;
    }

    public Class getBean() {
        return bean;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
}
