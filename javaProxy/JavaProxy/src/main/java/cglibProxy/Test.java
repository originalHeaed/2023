package cglibProxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

public class Test {
    public static void main(String[] args) {
        /* 生成的目标 class */
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\Users\\wanggh31690\\Desktop");

        /* 1. 创建 enhancer 对象，类似于 JDK 动态代理的 proxy 类 */
        Enhancer enhancer = new Enhancer();
        /* 2. cglib 基于继承实现的，需要指定父类 */
        enhancer.setSuperclass(TargetClass.class);
        /* 3. 指定拦截器实现实例（可以设置多个拦截器） */
        enhancer.setCallbacks(new Callback[]{new MyMethodInterceptor(), new MyMethodInterceptor2()});
        /* 4. 设置过滤器 */
        enhancer.setCallbackFilter(new MyCallBackFilter());
        /* 5. 获取继承 Target 后的代理类 */
        TargetClass targetClass = (TargetClass) enhancer.create();
        targetClass.doSomething();
        targetClass.doSomething2();
        targetClass.doSomething3();
    }
}
