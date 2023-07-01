package month7;

import jdk.nashorn.internal.codegen.SpillObjectCreator;

/**
 * 时间：2023/7/1
 * 问题描述：给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *      请你合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 切入点/解决思路：使用双指针 + 从两个数组的尾部开始合并数组
 * 感想：小意思
 */
public class Day01_merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /* 特殊情况处理 */
        if (nums2 == null | nums2 == null || nums1.length != (m + n)) return;
        /* 使用双指针开始合并 */
        int point1 = m - 1;
        int point2 = n - 1;
        int index = m + n -1;
        while (point1 >= 0 && point2 >= 0) {
            if (nums1[point1] > nums2[point2]) nums1[index--] = nums1[point1--];
            else nums1[index--] = nums2[point2--];
        }
        while (point2 >= 0) {
            nums1[index--] = nums2[point2--];
        }
     }
}