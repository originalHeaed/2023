package com.winterbe.java8.samples.myTest.testLamdba;

/**
 * 测试在 lamdba 表达式中使用本地局部变量
 */
public class TestLamdbaScope {
    @FunctionalInterface
    interface IMyMulti {
        Integer myMulti(Integer val);
    }

    public static void main(String[] args) {
        int base = 10;
        /**
         * 在 lamdba 表达式中使用了本地局部变量，然后在使用完成之后更改本地
         * 变量的值，这里会报错：Variable used in lambda expression should be final or effectively final
         */
//        IMyMulti myMulti = (val) -> base * val;
//        base = 20;
//        System.out.println(myMulti.myMulti(20));
    }
}
