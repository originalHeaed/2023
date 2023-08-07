package com.winterbe.java8.samples.myTest.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试 stream 中 collect 最终操作
 */
public class TestStreamCollect {
    public static void main(String[] args) {
        /* 1. 调用 collect 最终操作，传入一个 Collector 的实现类 */
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        String collect = integerStream.map(String::valueOf).collect(Collectors.joining("-"));
        System.out.println(collect);
        /* 2. 调用 collect 最终操作，传入收集器对象、收集规则，多个收集器之间的合并规则 */
        Stream<Integer> integerStream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        /* collect 第一个参数是提供一个收集器，第二个参数是提供收集器处理流中元素的规则，第三个参数是多个收集器的合并规则（在并发执行情况下会出现多个收集器） */
        StringBuilder collect1 = integerStream2.map(String::valueOf).collect(() -> new StringBuilder("收集开始"), StringBuilder::append, (sb1, sb2) -> sb1.append(sb2.toString()));
        System.out.println(collect1);
    }
}
