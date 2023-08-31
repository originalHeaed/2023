package month08;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 时间：2023/8/31
 * 问题描述：
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，
 * 请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 * 如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 * 切入点/解决思路：构造一个简单的图出来（使用链接矩阵）
 * 感想：中等偏上
 */
public class Day31_calcEquation {
    class Node {
        double value;
        String name;
        public Node() {};
        public Node(double _value, String _name) {
            value = _value;
            name = _name;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /* 特殊情况处理 */
        if (equations == null || values == null || queries == null) return null;
        double[] res = new double[queries.size()];
        /* 构造链接矩阵 */
        HashMap<String, List<Node>> hashMap = new HashMap<>();
        AtomicInteger i = new AtomicInteger(0);
        equations.forEach(ele -> {
            String first = ele.get(0);
            String second = ele.get(1);
            double value = values[i.get()];
            i.incrementAndGet();
            if (!hashMap.containsKey(first)) hashMap.put(first, new LinkedList<>());
            if (!hashMap.containsKey(second)) hashMap.put(second, new LinkedList<>());
            hashMap.get(first).add(new Node(value, second));
            hashMap.get(second).add(new Node(1/value, first));
        });
        /* 根据图需要每个问题的结果，并将在寻找过程中的其他可能问题缓存起来 */
        HashMap<String, Double> cache = new HashMap<>(); // 缓存所有可能的问题
        AtomicInteger index = new AtomicInteger(0);
        queries.forEach(ele -> {
            double tem = -1;
            String first = ele.get(0);
            String second = ele.get(1);
            String cacheKey = first + "/" + second;
            if (cache.containsKey(cacheKey)) tem = cache.get(cacheKey);
            else {
                tem = getRes(hashMap, first, second, cache);
            }
            res[index.get()] = tem;
            index.incrementAndGet();
        });
        return res;
    }

    /**
     * 使用深度优先搜索，从链接矩阵中获取 first/last 的值
     */
    private double getRes(HashMap<String, List<Node>> hashMap, String first, String last, HashMap<String, Double> cache) {
        /* 特殊情况处理 */
        if (!hashMap.containsKey(first) || !hashMap.containsKey(last)) return -1;
        /* 进行广度优先搜索 */
        double res = -1;
        Queue<Double> count = new LinkedList<>(); // 辅助计算抵达对应节点的值
        Queue<String> queue = new LinkedList<>(); // 辅助进行广度优先搜索
        Set<String> noRepeat = new HashSet<>(); // 用来存储已经访问过的节点，方式死循环
        queue.add(first);
        noRepeat.add(first);
        count.add(1d);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                double val = count.poll();
                if (last.equals(node)) res = val;
                /* 将所有没有访问过的节点加入队列中 */
                hashMap.get(node).forEach(ele -> {
                    if (!noRepeat.contains(ele.name)) {
                        noRepeat.add(ele.name);
                        queue.add(ele.name);
                        count.add(val * ele.value);
                        /* 在计算过长中将所有查找结果存入缓存中 */
                        cache.put(first + "/" + ele.name, val * ele.value);
                    }
                });
            }
        }
        return res;
    }

}