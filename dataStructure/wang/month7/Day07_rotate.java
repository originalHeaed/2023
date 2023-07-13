package month7;

import java.util.Arrays;
import java.util.Map;

/**
 * 时间：2023/7/7
 * 问题描述：给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 切入点/解决思路：直接挪，坑人点在于不能使用 for 循环一步一步的移动 k 步，因为可能会存在很多无用的挪动
 * 感想：就一点点有意思
 */
public class Day07_rotate {
    /**
     * 暴力法，时间复杂度：O（nk），k 可能超级大
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        /* 特殊情况处理 */
        if (nums == null || nums.length == 0 || (k % nums.length) == 0) return;
        /* 开始一步到位 */
        for (int i = 0; i < k; i++) {
            int val = nums[0];
            for (int j = 0; j < nums.length; j++) {
                int tem = nums[(j + 1) % nums.length];
                nums[(j + 1) % nums.length] = val;
                val = tem;
            }
        }
    }

    /**
     * 暴力法的优化 1，时间复杂度：O（n*（k%n）），时间复杂度将近 O（n^2），最大 O（n*（n-1））
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        /* 特殊情况处理 */
        if (nums == null || nums.length == 0 || (k % nums.length) == 0) return;
        /* 开始一步到位 */
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int val = nums[0];
            for (int j = 0; j < nums.length; j++) {
                int tem = nums[(j + 1) % nums.length];
                nums[(j + 1) % nums.length] = val;
                val = tem;
            }
        }
    }

    /**
     * 暴力法的优化 2，时间复杂度：O（n *（k%n）），时间复杂度将近 O（n^2），最大 O（n*（n/2））
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        /* 特殊情况处理 */
        if (nums == null || nums.length == 0 || (k % nums.length) == 0) return;
        /* 开始一步到位 */
        k = k % nums.length;
        if (k > (nums.length / 2)) {
            /* 左移动 */
            k = nums.length - k;
            for (int i = 0; i < k; i++) {
                int val = nums[0];
                for (int j = nums.length; j > 0; j++) {
                    int tem = nums[(j - 1) % nums.length];
                    nums[(j - 1) % nums.length] = val;
                    val = tem;
                }
            }
        } else {
            /* 右移动 */
            for (int i = 0; i < k; i++) {
                int val = nums[0];
                for (int j = 0; j < nums.length; j++) {
                    int tem = nums[(j + 1) % nums.length];
                    nums[(j + 1) % nums.length] = val;
                    val = tem;
                }
            }
        }
    }

    /**
     * 使用空间换时间，将时间复杂度降低到 O（n），将空间复杂度加倍 O（2n）
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        /* 特殊情况处理 */
        if (nums == null || nums.length == 0 || (k % nums.length) == 0) return;
        /* 开始进行挪动 */
        k = k % nums.length;
        int[] helper = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < helper.length; i++) {
            nums[(i + k) % nums.length] = helper[i];
        }
    }

    /**
     * 原地修改，时间复杂度：O（n），空间复杂度：O（1）
     * @param nums
     * @param k
     */
    public void rotate5(int[] nums, int k) {
        /* 特殊情况处理 */
        if (nums == null || nums.length == 0 || (k % nums.length) == 0) {
            return;
        }
        /* 开始进行挪动 */
    }
}