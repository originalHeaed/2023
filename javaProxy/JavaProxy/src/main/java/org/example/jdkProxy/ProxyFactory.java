package org.example.jdkProxy;

import sun.rmi.log.LogHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * 用于进行代理，对实际方法的调用进行增强
 */
public class ProxyFactory {
    /**
     * 使用泛型
     * @param target
     * @return
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    public static <T> T getTargetProxy(T target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader()
                , target.getClass().getInterfaces()
                , new EnhanceMethod(target));
    }

    /**
     * 内部类，实现对 target 的增强
     */
    private static class EnhanceMethod<T> implements InvocationHandler {

        private T target;

        public EnhanceMethod(T target) {
            Objects.requireNonNull(target);
            this.target = target;
        }

        /**
         *
         * @param proxy the proxy instance that the method was invoked on
         *
         * @param method the {@code Method} instance corresponding to
         * the interface method invoked on the proxy instance.  The declaring
         * class of the {@code Method} object will be the interface that
         * the method was declared in, which may be a superinterface of the
         * proxy interface that the proxy class inherits the method through.
         *
         * @param args an array of objects containing the values of the
         * arguments passed in the method invocation on the proxy instance,
         * or {@code null} if interface method takes no arguments.
         * Arguments of primitive types are wrapped in instances of the
         * appropriate primitive wrapper class, such as
         * {@code java.lang.Integer} or {@code java.lang.Boolean}.
         *
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before execute the target method, common enhance it");
            return method.invoke(target, args);
        }
    }
}
