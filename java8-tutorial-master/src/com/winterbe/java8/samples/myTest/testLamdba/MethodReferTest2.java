package com.winterbe.java8.samples.myTest.testLamdba;

/**
 * 方法引用传递2
 * this 隐式参数
 */
public class MethodReferTest2 {
    /**
     * 函数式接口
     */
    @FunctionalInterface
    interface IContact {
        String contact(MethodReferTest2 s1, MethodReferTest2 s2);
    }

    public String val;

    public MethodReferTest2(String val) {
        this.val = val;
    }

    /**
     * 待传入引用的方法
     */
    public String myContact(MethodReferTest2 s2) {
        return this.val + s2.val;
    }

    public static void main(String[] args) {
        /**
         * 这里 myContact 和函数接口中 contact 抽象方法的入参个数不同，但是仍然可以被赋予给函数接口；
         * 原因：myContact 是实例方法，需要对象来调用，实例对象在调用 myContact 时会加上一个隐式入参 this
         * 因此隐式入参，再加上 myContact 入参需要传递一个对象，这样一来入参类型和入参格式就和函数接口中的 contact 一致了
         */
        IContact contact = MethodReferTest2::myContact;
        System.out.println(contact.contact(new MethodReferTest2("test1"), new MethodReferTest2("test2")));
    }
}
