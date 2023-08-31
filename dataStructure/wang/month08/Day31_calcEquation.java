package month08;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ʱ�䣺2023/8/31
 * ����������
 * ����һ������������ equations ��һ��ʵ��ֵ���� values ��Ϊ��֪���������� equations[i] = [Ai, Bi] �� values[i] ��ͬ��ʾ��ʽ Ai / Bi = values[i] ��ÿ�� Ai �� Bi ��һ����ʾ�����������ַ�����
 * ����һЩ������ queries ��ʾ�����⣬���� queries[j] = [Cj, Dj] ��ʾ�� j �����⣬
 * ���������֪�����ҳ� Cj / Dj = ? �Ľ����Ϊ�𰸡�
 * ���� ��������Ĵ� ���������ĳ���޷�ȷ���Ĵ𰸣����� -1.0 �������𰸡�
 * ��������г����˸�������֪������û�г��ֵ��ַ�����Ҳ��Ҫ�� -1.0 �������𰸡�
 * �����/���˼·������һ���򵥵�ͼ������ʹ�����Ӿ���
 * ���룺�е�ƫ��
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
        /* ����������� */
        if (equations == null || values == null || queries == null) return null;
        double[] res = new double[queries.size()];
        /* �������Ӿ��� */
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
        /* ����ͼ��Ҫÿ������Ľ����������Ѱ�ҹ����е������������⻺������ */
        HashMap<String, Double> cache = new HashMap<>(); // �������п��ܵ�����
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
     * ʹ��������������������Ӿ����л�ȡ first/last ��ֵ
     */
    private double getRes(HashMap<String, List<Node>> hashMap, String first, String last, HashMap<String, Double> cache) {
        /* ����������� */
        if (!hashMap.containsKey(first) || !hashMap.containsKey(last)) return -1;
        /* ���й���������� */
        double res = -1;
        Queue<Double> count = new LinkedList<>(); // ��������ִ��Ӧ�ڵ��ֵ
        Queue<String> queue = new LinkedList<>(); // �������й����������
        Set<String> noRepeat = new HashSet<>(); // �����洢�Ѿ����ʹ��Ľڵ㣬��ʽ��ѭ��
        queue.add(first);
        noRepeat.add(first);
        count.add(1d);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                double val = count.poll();
                if (last.equals(node)) res = val;
                /* ������û�з��ʹ��Ľڵ��������� */
                hashMap.get(node).forEach(ele -> {
                    if (!noRepeat.contains(ele.name)) {
                        noRepeat.add(ele.name);
                        queue.add(ele.name);
                        count.add(val * ele.value);
                        /* �ڼ�������н����в��ҽ�����뻺���� */
                        cache.put(first + "/" + ele.name, val * ele.value);
                    }
                });
            }
        }
        return res;
    }

}