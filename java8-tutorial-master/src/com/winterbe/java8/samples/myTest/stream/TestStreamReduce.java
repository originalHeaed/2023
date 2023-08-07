package com.winterbe.java8.samples.myTest.stream;

import java.util.Arrays;
import java.util.Optional;

/**
 * 测试 stream 中 reduce 最终操作
 */
public class TestStreamReduce {
    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5,6,7,8,9};
        /* 将多个字符串进行连接，最后返回一个 Optional 对象 */
        Optional<String> reduce = Arrays.stream(test).mapToObj(val -> String.valueOf(val)).reduce((val1, val2) -> val1 + val2);
        System.out.println(reduce.orElse("获取的值为空")); // 输出：123456789
        /* 给予一个初始值，然后将流的结果按照指定的规则进行连接，最后返回一个与初始值类型一致的对象 */
        String res = Arrays.stream(test).mapToObj(val -> String.valueOf(val)).reduce("最终结果", (val1, val2) -> val1 + val2);
        System.out.println(res); // 输出：最终结果123456789

    }
}
