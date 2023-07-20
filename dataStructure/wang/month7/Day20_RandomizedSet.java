package month7;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;

/**
 * 时间：2023/7/20
 * 问题描述：
 *  实现RandomizedSet 类：
 *  RandomizedSet() 初始化 RandomizedSet 对象
 *  bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 *  bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 *  int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 *  你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 * 切入点/解决思路：使用数组 + hash 表
 * 感想：有点意思
 */
public class Day20_RandomizedSet {

    /**
     * 数组的最大长度（最多会连续插入 2 * 10^5）
     */
    private static final Integer MAX_LENGTH = 200001;

    /**
     * map 存放元素值和元素在数组中的下标，主要用来插入和删除时实现 O（1）
     */
    private Map<Integer, Integer> map;

    /**
     * 存放还存活的元素，用来实现在 O（1）时间复杂度内获取随机一个元素
     */
    private int[] arr;

    /**
     * 记录最后一个可用元素下标
     */
    private int count;

    public Day20_RandomizedSet() {
        map = new HashMap<>(MAX_LENGTH);
        arr = new int[MAX_LENGTH];
        count = -1;
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        arr[++count] = val;
        map.put(val, count);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Integer index = map.remove(val);
        /* 将数组中最后一个元素补充到删除的地方 */
        arr[index] = arr[count];
        /* 更新最后一个元素在 map 中的下标（如果删除的是最后一个元素就不需要更新了） */
        if (index != count) map.put(arr[count], index);
        count--;
        return true;
    }

    public int getRandom() {
        /* 特殊情况处理 */
        if (count < 0) return -1;
        /* 获取 [0, count] 的随机下标 */
        Random random = new Random();
        int i = random.nextInt(count + 1);
        return arr[i];
    }

    public static void main(String[] args) {
        System.out.println(10^5);
    }
}