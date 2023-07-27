package com.winterbe.java8.samples.myTest.testLamdba;

public class TestFunctionalIn {
    public static void testFunctionalInterface() {
        /* 使用 lamdba 表达式实现函数式接口 */
        IDataChange<String, Integer> dataChange = (val) -> { return String.valueOf(val);};
        /* 调用接口 */
        System.out.println(dataChange.deal(10));
    }

    public static void main(String[] args) {
        testFunctionalInterface();
    }
}
