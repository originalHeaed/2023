package com.winterbe.java8.samples.myTest.stream;

import java.util.stream.Stream;

/**
 * 测试 stream 中 Count 最终操作
 */
public class TestStreamCount {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        /* 统计最终结果个数 */
        long count = integerStream.filter((val) -> val % 2 == 0).count();
        System.out.println(count);
    }
}
