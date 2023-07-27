package com.winterbe.java8.samples.myTest.testDefInter;

/**
 * 继承 IDefTest，直接调用接口中的默认方法
 */
public class Default_Methods_For_Interfaces implements IDefTest{

    @Override
    public String test2() {
        return test();
    }

    public static void main(String[] args) {
        Default_Methods_For_Interfaces test = new Default_Methods_For_Interfaces();
        System.out.println(test.test2());
    }
}
