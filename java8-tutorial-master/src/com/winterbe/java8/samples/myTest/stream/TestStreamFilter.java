package com.winterbe.java8.samples.myTest.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * 测试 stream 中的 filter 中间操作
 */
public class TestStreamFilter {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        /* 需要传递一个 predicate 函数式接口，来定义过滤规则，只有元素值 mod 3 为 0 则将该元素保留，否则去掉该元素 */
        ArrayList<Integer> collect = integerStream.filter(val -> val % 3 == 0)
                .collect(() -> new ArrayList<Integer>(), (contain, val) -> contain.add(val), (contain1, contain2) -> contain1.addAll(contain2));
    }
}
