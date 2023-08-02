package com.winterbe.java8.samples.myTest.testLamdba;

/**
 * 测试 lamdba 使用实例变量和静态变量
 */
public class TestLamdbaScope3 {
    /**
     * 函数式接口
     */
    @FunctionalInterface
    interface IMyMulti {
        Integer multi(Integer val);
    }

    private int base1 = 10;
    static Integer base2 = 20;

    public void test() {
        /**
         * lamdba 表达式使用实例变量，需要注意的是，这里实例变量可以非 final
         */
        IMyMulti myMulti = (val) -> val * base1;
        base1 = 20;
        System.out.println(myMulti.multi(10));
        /* lamdba 表达式中使用静态变量，这里也可以不加 final */
        myMulti = (val) -> val * base2;
        base2 = 30;
        System.out.println(myMulti.multi(10));
    }

    public static void main(String[] args) {
        TestLamdbaScope3 testLamdbaScope3 = new TestLamdbaScope3();
        testLamdbaScope3.test();
    }
}
