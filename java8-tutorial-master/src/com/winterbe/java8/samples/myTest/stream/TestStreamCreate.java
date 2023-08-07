package com.winterbe.java8.samples.myTest.stream;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 测试 stream 的四种创建方式
 */
public class TestStreamCreate {
    public static Integer i = 1;

    public static void main(String[] args) {
        /* 通过指定元素来创建 stream */
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        /* 通过数组来创建 stream（上面指定元素来创建 stream 本质就是这种） */
        IntStream stream1 = Arrays.stream(new int[]{1, 2, 3, 4, 5});
        /* 通过 Collection 来创建 stream，所有实现 Collection 接口的集合类都含有 stream() 方法, Map 不行 */
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Stream<Integer> stream = list.stream();
        /* 通过 Supplier 接口实现类创建 stream */
        Stream<Integer> generate = Stream.generate(() -> i); // 理论上可以无限产生数据（这里限制于 int 的最大值）
        System.out.println(generate.map(val -> val + 1).limit(10).count());
    }
}
