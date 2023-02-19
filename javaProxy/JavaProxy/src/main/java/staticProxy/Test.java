package staticProxy;

public class Test {
    public static void main(String[] args) {
        ProxyTarget proxyTarget = new ProxyTarget(new Target());
        proxyTarget.doSomething1("doSomething1");
        proxyTarget.doSomething2("1", "2");
    }
}
