package com.winterbe.java8.samples.myTest.Optional;

import java.util.Optional;

public class TestOptionals {
    public static void main(String[] args) {
        String val = "12";
        /* 返回 boolean 值，判断是否为空 */
        Optional.of(val).isPresent();
        /* 当 val 为 null 时返回默认值 */
        System.out.println(Optional.of(val).orElse("默认值"));
        /* 将非空的 val 按照 Predicate 进行过滤，如果过滤后结果为空则返回默认值，否则 val */
        System.out.println(Optional.of(val).filter((tar) -> "target".equals(tar)).orElse("默认值"));
    }
}
