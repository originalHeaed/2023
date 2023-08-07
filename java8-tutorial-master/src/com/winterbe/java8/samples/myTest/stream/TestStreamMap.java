package com.winterbe.java8.samples.myTest.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 stream 中 map 中间操作
 */
public class TestStreamMap {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        /* 使用 map 将流中数据按照指定规则进行转换，传入一个 Function 函数式接口实现 */
        Integer reduce = list.stream().map((val) -> Integer.valueOf(val)).reduce(10, (val1, val2) -> val1 + val2);
        System.out.println(reduce);
    }
}
