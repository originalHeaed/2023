package cglibProxy;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class MyCallBackFilter implements CallbackFilter {
    public static String METHOD1 = "doSomething";
    /**
     * 根据被拦截的方法调用指定的 callBack
     * @param method
     * @return
     */
    @Override
    public int accept(Method method) {
        if (METHOD1.equals(method.getName())) {
            return 0;
        }
        return 1;
    }
}
