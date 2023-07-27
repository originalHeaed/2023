package com.winterbe.java8.samples.myTest.testDefInter;

public interface IDefTest {
    /**
     * 定义实现测试接口
     * @return
     */
    String test2();

    /**
     * jdK 1.8 中的默认方法
     * @return
     */
    default String test() {
        return "hhh";
    }
}
