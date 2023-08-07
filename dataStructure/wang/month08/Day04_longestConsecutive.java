package month08;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 时间：2023/8/4
 * 问题描述：
 *  给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *  请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 切入点/解决思路：
 * 感想：
 */
public class Day04_longestConsecutive {

    /**
     * 使用排序的方式
     * 时间复杂度：O（nlogn）
     */
    public int longestConsecutive(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null || nums.length == 0) return 0;
        /* 开始处理 */
        Arrays.sort(nums);
        int total = 1;
        int tem = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                total = Math.max(total ,tem);
                tem = 1;
            } else if (nums[i] != nums[i - 1]) tem++;
        }
        total = Math.max(total ,tem);
        return total;
    }

    /**
     * 使用 map
     * 时间复杂度：O（n）
     */
    public int longestConsecutive2(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null || nums.length == 0) return 0;
        /* 开始处理 */
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(val -> set.add(val));
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int temLongest = 1;
                int val = nums[i] + 1;
                while (set.contains(val)) {
                    val++;
                    temLongest++;
                }
                longest = Math.max(temLongest, longest);
            }
        }
        return longest;
    }

}