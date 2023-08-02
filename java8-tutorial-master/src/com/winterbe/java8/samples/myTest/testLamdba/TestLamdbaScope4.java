package com.winterbe.java8.samples.myTest.testLamdba;

/**
 * lamdba 表达式中不能使用函数式接口中定义的默认方法
 */
public class TestLamdbaScope4 {
    @FunctionalInterface
    interface IMyTest {
        void test();

        default void defaultMeth() {
            System.out.println("调用了函数式接口中的默认方法");
        }
    }

    public static void main(String[] args) {
        /* 无法在 lamdba 表达式中调动内部的默认方法 */
//        IMyTest myTest = () -> {defaultMeth()};
    }
}