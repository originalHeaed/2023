package staticProxy;

public class Target implements ITarget {

    /**
     * 被代理的方法一
     * @param val
     */
    @Override
    public void doSomething1(String val) {
        System.out.println("the val is: " + val);
    }

    /**
     * 被代理的方法二
     * @param val
     * @param val2
     */
    @Override
    public void doSomething2(String val, String val2) {
        System.out.println("the val are:" + val + ", " + val2) ;
    }
}
