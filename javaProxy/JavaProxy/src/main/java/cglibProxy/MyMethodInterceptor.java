package cglibProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 定义方法拦截，对被拦截的方法进行增强
 */
public class MyMethodInterceptor implements MethodInterceptor {

    /**
     * 方法拦截
     * @param o 继承目标类代理类的实例对象
     * @param method 被拦截的方法
     * @param objects  被拦截方法的参数值
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("使用反射，对被拦截的方法1进行增强");
        Object invoke = methodProxy.invokeSuper(o, objects); /* 调用被拦截的方法（注意这里并没有使用反射） */
        return invoke;
    }
}
