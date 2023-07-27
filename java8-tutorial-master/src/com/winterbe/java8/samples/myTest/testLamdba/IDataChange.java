package com.winterbe.java8.samples.myTest.testLamdba;

/**
 * @author wanggh31690
 * 定义一个函数式接口，并且添加了 FunctionalInterface 注解防止后面其他人在该注解中添加其他的抽象方法
 */
@FunctionalInterface
public interface IDataChange<T, R> {
    /**
     * 处理数据
     */
    T deal(R val);
}
