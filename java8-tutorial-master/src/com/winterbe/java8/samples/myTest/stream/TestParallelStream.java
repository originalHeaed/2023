package com.winterbe.java8.samples.myTest.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 测试 stream 中并行 stream
 */
public class TestParallelStream {
    public static void main(String[] args) {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        /* 使用非并行的方式进行排序 */
        long l = System.nanoTime();
        values.stream().sorted();
        long l1 = System.nanoTime();
        System.out.println("串行方式执行耗时：" + (l1 - l)); // 串行方式执行耗时：2609200
        /* 使用并行方式进行排序，只需要调用 parallel 即可将串行流转为并行 */
        long l2 = System.nanoTime();
        values.stream().parallel().sorted();
        long l3 = System.nanoTime();
        System.out.println("并行方式执行耗时：" + (l3 - l2)); // 并行方式执行耗时：11500
    }
}
