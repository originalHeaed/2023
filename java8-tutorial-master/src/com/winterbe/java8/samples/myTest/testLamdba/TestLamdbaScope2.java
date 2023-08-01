package com.winterbe.java8.samples.myTest.testLamdba;

/**
 * lamdba 表达式使用局部变量
 */
public class TestLamdbaScope2 {
    @FunctionalInterface
    interface IMyMulti {
        Integer myMulti(Integer val);
    }

    public static void main(String[] args) {
        Integer base = 20;
        /* 这里使用了局部变量，会被默认加上 final */
        IMyMulti myMulti = (val) -> base * val;
        System.out.println(myMulti.myMulti(20));
    }
}
