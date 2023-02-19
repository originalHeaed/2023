package staticProxy;

/**
 * 直接调用类的行为规范器
 */
public interface ITarget {
    void doSomething1(String val);

    void doSomething2(String val, String val2);
}
