package month7;

import java.util.Arrays;

/**
 * 时间：2023/7/21
 * 问题描述：
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * 切入点/解决思路：
 * 感想：中等
 */
public class Day21_candy {
    /**
     * 时间复杂度：O（n^2），空间复杂度：O（n）
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        /* 特殊情况处理 */
        if (ratings == null || ratings.length == 0) return 0;
        /* 开始处理 */
        int[] helper = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            helper[i] = 1;
        }
        for (int i = 0; i < ratings.length; i++) {
            /* 将 i 左边所有元素值更新 */
            int index = i - 1;
            while (index >= 0 && ratings[index] > ratings[index + 1]) {
                helper[index] = Math.max(helper[index + 1] + 1, helper[index]);
                index--;
            }
            /* 将 i 右边的所有元素更新 */
            index = i + 1;
            while (index < ratings.length && ratings[index] > ratings[index - 1]) {
                helper[index] = Math.max(helper[index - 1] + 1, helper[index]);
                index++;
            }
        }
        /* 统计最小花费 */
        int total = 0;
        for (int i = 0; i < ratings.length; i++) {
            total += helper[i];
        }
        return total;
    }

    /**
     * 使用两次遍历法，来计算每个孩子最少需要多少糖果就能够满足要求
     *
     * @param ratings
     * @return
     */
    public int candy2(int[] ratings) {
        /* 特殊情况处理 */
        if (ratings == null || ratings.length == 0) return 0;
        int[] helper = new int[ratings.length];
        Arrays.fill(helper, 1);
        /* 从左到右遍历，保证每个孩子都有一个，且相邻孩子，如果右边孩子分数高则糖果一定比左边孩子糖果多 */
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) helper[i] = Math.max(helper[i - 1] + 1, helper[i]);
        }
        /* 从右到左遍历，保证每个孩子都一个糖果，且相邻孩子，如果左边孩子分数高则糖果一定比右边孩子糖果多 */
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) helper[i] = Math.max(helper[i + 1] + 1, helper[i]);
        }
        /* 统计最少糖果 */
        int total = 0;
        for (int i = 0; i < helper.length; i++) {
            total += helper[i];
        }
        return total;
    }
}