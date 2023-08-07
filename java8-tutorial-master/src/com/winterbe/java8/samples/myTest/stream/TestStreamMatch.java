package com.winterbe.java8.samples.myTest.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 测试 stream 中 match 中间操作
 */
public class TestStreamMatch {
    public static class MyTest implements Supplier<Integer> {
        public int i = 1;


        @Override
        public Integer get() {
            i++;
            return i;
        }
    }


    public static void main(String[] args) {
        MyTest myTest = new MyTest();
        /* 传入一个 Predicate 函数式接口实现，只要流中任何一个数据符合函数式接口 则返回 true
        （注意如果如果找到一个匹配的，就会停止后续数据的判断，不会将所有数据都计算一次）  */
        Stream<Integer> generate = Stream.generate(myTest);
        boolean b = generate.limit(100).allMatch((val) -> val < 10);
        System.out.println(b);
        /* 传入一个 Predicate 函数式接口实现，流中所有数据符合函数式接口 则返回 true
        * （注意如果如果找到一个匹配的，就会停止后续数据的判断，不会将所有数据都计算一次）  */
        Stream<Integer> generate2 = Stream.generate(myTest);
        boolean b1 = generate2.limit(100).allMatch((val) -> val == 10);
        System.out.println(b1);
        /* 传入一个 Predicate 函数式接口实现，流中所有数据都不符合函数式接口 则返回 true
        * （注意如果如果找到一个匹配的，就会停止后续数据的判断，不会将所有数据都计算一次）  */
        Stream<Integer> generate3 = Stream.generate(myTest);
        boolean b2 = generate3.limit(100).noneMatch((val) -> val == 10);
        System.out.println(b2);
    }
}
