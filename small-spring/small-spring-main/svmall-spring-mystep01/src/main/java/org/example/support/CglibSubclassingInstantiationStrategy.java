package org.example.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.example.Exception.BeansException;
import org.example.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 使用 cglib 动态代理实现 bean 对象的创建
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, Constructor ctor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        /* 创建 bean 的子类 */
        enhancer.setSuperclass(beanDefinition.getBean());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        /* 返回 bean 对象 */
        if (args == null || args.length == 0 || ctor == null) return enhancer.create(); // 返回无参对象
        return enhancer.create(ctor.getParameterTypes(), args); // 返回有参对象
    }
}
