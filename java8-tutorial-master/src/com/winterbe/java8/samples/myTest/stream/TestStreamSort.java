package com.winterbe.java8.samples.myTest.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 测试 stream 中使用 sort 中间操作
 */
public class TestStreamSort {
    public static void main(String[] args) {
        Stream<String> stream = Arrays.stream(new String[]{"1", "22", "333", "4444", "55555"});
        /* 将 stream 中数据按照自然顺序进行排序 */
        stream.sorted().forEach(System.out::println);
        /* 传入一个比较器 Comparator 将 stream 中的数据进行排序 */
        Stream<String> stream2 = Arrays.stream(new String[]{"1", "22", "333", "4444", "55555"});
        stream2.sorted((val1, val2) -> val2.length() - val1.length()).forEach(System.out::println);
    }
}
