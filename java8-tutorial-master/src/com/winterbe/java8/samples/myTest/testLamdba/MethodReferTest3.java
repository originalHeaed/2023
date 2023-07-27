package com.winterbe.java8.samples.myTest.testLamdba;

/**
 * 方法引用传递3
 * 实例引用传递给函数接口的问题
 */
public class MethodReferTest3 {
    /**
     * 函数接口
     */
    @FunctionalInterface
    interface IDateChange {
        Integer dateChange(String val);
    }

    /**
     * 待传递的引用对象
     */
    public Integer myDateChange(String val) {
        return Integer.valueOf(val);
    }

    public static void main(String[] args) {
        /**
         * 虽然 myDateChange 中方法参数类型和参数格式以及返回类型和函数接口中 dateChange 保持了一致，但是由于该方法时实例方法
         * public Integer myDateChange(String val) 相当于 public static Integer myDateChange(MethodReferTest3 obj, String val)
         * 因此引用传递失败，如果需要修改可以在函数接口抽象方法添加一个入参
         */
//        IDateChange dateChange = MethodReferTest3::myDateChange;
    }
}
