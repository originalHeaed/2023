package com.winterbe.java8.samples.myTest.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream 的基本使用
 * 简单来说多个 Stream 接口实现类互相引用，在最终操作中按照创建的顺序来执行中间操作，最终产生一个明确的结果（实际上比这个复杂很多）
 */
public class TestStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(30);
        list.add(80);
        list.add(40);
        Stream<Integer> stream = list.stream(); // 创建一个流
        // 添加一个的中间操作（这是一个过滤操作，它只会记录操作，不会将操作应用到数据中）
        Stream<Integer> integerStream = stream.filter((val) -> val > 10);
        // 添加一个新中间操作（这是一个元素映射操作，该步骤只会记录操作，不会将操作应用到数据中）
        Stream<String> stringStream = integerStream.map(val -> String.valueOf(val) + 'a');
        // 添加一个最终操作，并开始对数据进行处理，会按照上面添加的步骤依次对数据进行处理，然后输出结果
        String collect1 = stringStream.collect(Collectors.joining(":"));
        System.out.println(collect1);
        /* 上面的链式写法 */
        String collect = list.stream().filter((val) -> val > 10)
                .map(val -> String.valueOf(val) + 'a')
                .collect(Collectors.joining(":"));
        System.out.println(collect);
    }
}
