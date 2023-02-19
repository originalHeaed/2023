package staticProxy;

/**
 * 代理类，需要实现和目标类一样的接口，或者自行定义需要代理目标类的方法（务必和目标类保持一致—）
 */
public class ProxyTarget implements ITarget{

    /**
     * 被代理的对象
     */
    private ITarget target;

    /**
     * 构造时传入目标类
     * @param target
     */
    public ProxyTarget(ITarget target) {
        this.target = target;
    }

    /**
     * 被代理的方法一
     * @param val
     */
    @Override
    public void doSomething1(String val) {
        System.out.println("before execute the target method, common enhance it");
        target.doSomething1(val);
    }

    /**
     * 被代理的方法二
     */
    @Override
    public void doSomething2(String val, String val2) {
        System.out.println("before execute the target method, common enhance it");
        target.doSomething2(val, val2);
    }
}
