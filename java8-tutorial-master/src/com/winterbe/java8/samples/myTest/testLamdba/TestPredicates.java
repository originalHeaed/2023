package com.winterbe.java8.samples.myTest.testLamdba;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 测试 1.8 自带的函数式接口使用
 */
public class TestPredicates {
    public static void main(String[] args) {
        /* 测试断言函数式接口 */
        Predicate<String> predicate = (val) -> "test".equals(val);
        System.out.println(predicate.test("test1"));

        /* 测试数据处理函数式接口 */
        Function<String, String> function = (val) -> val + "2";
        Function<String, String> before = (val) -> val + "1";
        Function<String, String> then = (val) -> val + "3";
        // 先调用 before，然后将 before 处理的结果作为 function 的入参
        Function<String, String> first = function.compose(before);
        System.out.println(first.apply("begin"));
        // 先调用 before，然后将 before 处理结果作为 funciotn 的入参，然后将 funciton 处理的结果作为入参调用 then
        Function<String, String> last = first.andThen(then);
        System.out.println(last.apply("test"));

        /* 测试数据生产函数式接口 */
        Supplier<String> stringSupplier = () -> "test";
        System.out.println(stringSupplier.get());

        /* 测试数据消费函数式接口 */
        Consumer<String> consumer1 = (val) -> System.out.println("消费者1消费了：" + val);
        Consumer<String> consumer2 = (val) -> System.out.println("消费者2消费了：" + val);
        Consumer<String> consumer = consumer1.andThen(consumer2);
        consumer.accept("food");

        /* 测试比较函数式接口 */
        Comparator<String> comparator = (val1, val2) -> val1.length() - val2.length();
        System.out.println(comparator.compare("12", "32"));
    }
}
