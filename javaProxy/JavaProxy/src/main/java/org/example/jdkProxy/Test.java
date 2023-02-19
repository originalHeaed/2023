package org.example.jdkProxy;

public class Test {
    public static void main(String[] args) {
        ITarget targetProxy = ProxyFactory.getTargetProxy(new Target());
        targetProxy.doSomething1("1");
        targetProxy.doSomething2("2", "3");
    }
}
