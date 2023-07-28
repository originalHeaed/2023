package month7;

import java.util.Map;

/**
 * 时间：2023/7/28
 * 问题描述：
 *  给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *  找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *  返回容器可以储存的最大水量。
 *  说明：你不能倾斜容器。
 * 切入点/解决思路：使用双指针，首尾指针
 * 感想：中等
 */
public class Day28_maxArea {
    /**
     * 时间复杂度：O（n），空间复杂度：O（1）
     */
    public int maxArea(int[] height) {
        /* 特殊情况处理 */
        if (height == null || height.length <= 1) return 0;
        /* 开始计算容量 */
        int head = 0;
        int tail = height.length - 1;
        int capacity = 0;
        while (head != tail) {
            capacity = Math.max(capacity, (tail - head) * Math.min(height[head], height[tail]));
            if (height[head] > height[tail]) tail--;
            else head++;
        }
        return capacity;
    }
}