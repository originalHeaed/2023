package month7;

/**
 * 时间：2023/7/24
 * 问题描述：
 *     给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 切入点/解决思路：可以积水的条件是先下降再上升，才可以形成积水的条件，按照这个条件去寻找就行；（使用双指针）
 * 感想：困难
 */
public class Day24_trap {
    /**
     * 找到最高点
     * 从最高点向左找到次高点，计算两者之间可以积水大小，然后将次高点作为最高点，依次进行直到最左边界；
     * 从最高点向右找到次高点，计算两者之间可以积水大小，然后将次高点作为最高点，重复这个步骤直到最右边界；
     * 时间复杂度：O（n），空间复杂度：O（n）
     */
    public int trap(int[] height) {
        /* 特殊情况处理 */
        if (height == null || height.length <= 2) return 0;
        /* 计算可以积累多少雨水 */
        int[] leftHelper = new int[height.length]; // i 元素左边高度最高的元素下标
        int[] rightHelper = new int[height.length]; // i 元素右边高度最高的元素下标
        int index = 0; // 整个数组中最高的元素下标
        int total = 0;
        /* 获取 [0, i) 最大高度下标，记录在 leftHelper[i] */
        leftHelper[0] = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[index] < height[i]) index = i;
            leftHelper[i] = height[i - 1] > height[leftHelper[i - 1]] ? i - 1 : leftHelper[i - 1]; // 不建议使用 >=
        }
        leftHelper[0] = -1;
        /* 获取 (i, height.length - 1] 最大高度下标，记录在 rightHelper[i] */
        rightHelper[rightHelper.length - 1] = rightHelper.length - 1;
        for (int i = height.length - 2; i >= 0; i--) {
            rightHelper[i] = height[i + 1] > height[rightHelper[i + 1]] ? i + 1 : rightHelper[i + 1]; // 不建议适用 >=
        }
        rightHelper[rightHelper.length - 1] = -1;
        /* 从最高点开始左，计算最高点到次高点积水容量，然后重复这个步骤，直到左边界 */
        int leftIndex = index;
        while (leftHelper[leftIndex] != -1) {
            int shortest = Math.min(height[leftIndex], height[leftHelper[leftIndex]]);
            for (int i = leftHelper[leftIndex]; i <= leftIndex ; i++) {
                total += shortest > height[i] ? shortest - height[i] : 0;
            }
            leftIndex = leftHelper[leftIndex];
        }
        /* 从最高点开始向右，计算最高点到次高点积水容量，然后重复这个步骤，直到右边界 */
        int rightIndex = index;
        while (rightHelper[rightIndex] != -1) {
            int shortest = Math.min(height[rightIndex], height[rightHelper[rightIndex]]);
            for (int i = rightIndex; i <= rightHelper[rightIndex]; i++) {
                total += shortest > height[i] ? shortest - height[i] : 0;
            }
            rightIndex = rightHelper[rightIndex];
        }
        return total;
    }
}