package staticProxy;

public class ProxyTarget implements ITarget{

    /**
     * 被代理的对象
     */
    private ITarget target;

    public ProxyTarget(ITarget target) {
        this.target = target;
    }

    @Override
    public void doSomething1(String val) {
        System.out.println("before execute the target method, common enhance it");
        target.doSomething1(val);
    }

    @Override
    public void doSomething2(String val, String val2) {
        System.out.println("before execute the target method, common enhance it");
        target.doSomething2(val, val2);
    }
}
