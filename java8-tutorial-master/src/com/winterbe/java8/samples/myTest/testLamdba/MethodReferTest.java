package com.winterbe.java8.samples.myTest.testLamdba;

/**
 * 方法引用的传递
 * @author wanggh31690
 */
public class MethodReferTest {
    /**
     * 函数式接口
     */
    @FunctionalInterface
    interface IDateChange {
        /**
         * 抽象方法用来更改数据类型，将 String 改为 Integer
         * @param val
         * @return
         */
        Integer change(String val);
    }

    /**
     * 静态方法将 String 转为 Interger
     */
    public static Integer myChage(String val) {
        return Integer.valueOf(val);
    }

    public static void testMethodReferTest() {
        /**
         * 直接将方法的引用传递给对象，当调用 IDateChage 中的 chage 时实际上是调用
         * MethodReferTest 中的 myChage 方法
         * 这里 myChage 入参类型、入参格式和返回类型都与函数接口中 change 一致，因此可以直接传递引用
         */
        IDateChange dateChange = MethodReferTest::myChage;
        System.out.println(dateChange.change("100"));
    }

    public static void main(String[] args) {
        testMethodReferTest();
    }
}
