package month7;

/**
 * 时间：2023/7/21
 * 问题描述：
 *  在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *  你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *  给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * 切入点/解决思路：使用贪心思想
 * 感想：稍微
 */
public class Day21_canCompleteCircuit {
    /**
     * 使用暴力法，把每一种情况都考虑一次
     * 时间复杂度：O（n^2）
     * 空间复杂度：O（n）
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /* 特殊情况处理 */
        if (gas == null || cost == null || gas.length != cost.length || gas.length == 0) return -1;
        int[] helper = new int[gas.length]; // 从 i 号加油站到 i+1 号加油站，单纯使用 i 号加油站的油还剩下多少
        for (int i = 0; i < gas.length; i++) {
            helper[i] = gas[i] - cost[i];
        }
        /* 循环处理 */
        for (int i = 0; i < helper.length; i++) {
            int count = 0;
            int index = i;
            do {
                count += helper[index];
                if (count < 0) break;
                index = (index + 1) % helper.length;
            } while (index != i);
            if (count >= 0) return i;
        }
        return -1;
    }

    /**
     * 适用贪心算法
     * 逆向推导，使用双指针如果范围内的和为负值，则左指针左移，如果范围内的和值为正值则右指针右移（循环数组），最后如果 left 和 right 相遇
     * 且范围内的值之和大于等于 0 则表示存在这么一个加油站，返回 left 值，否则返回 -1；
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        /* 特殊情况处理 */
        if (gas == null || cost == null || gas.length != cost.length || gas.length == 0) return -1;
        /* 循环处理 */
        int left = 0;
        int right = 0;
        int total = gas[left] - cost[left];
        do {
            int tem = 0;
            if (total >= 0) {
                right = (right + 1) % gas.length;
                tem = right;
            } else {
                left = left == 0 ? gas.length - 1 : left - 1;
                tem = left;
            }
            if (right != left) total += gas[tem] - cost[tem];
        } while (left != right);
        return total >= 0 ? left : -1;
    }

}