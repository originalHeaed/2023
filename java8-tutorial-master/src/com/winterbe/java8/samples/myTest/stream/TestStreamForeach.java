package com.winterbe.java8.samples.myTest.stream;

import java.util.stream.Stream;

/**
 * 测试 stream 中 foreach
 */
public class TestStreamForeach {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        /* foreach 对所有元素进行处理，无返回值 */
        integerStream.map(val -> val * 2).forEach(System.out::println);
    }
}
