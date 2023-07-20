package month7;

/**
 * 时间：2023/7/20
 * 问题描述：
 *  给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *  题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *  请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 切入点/解决思路：使用空间换时间
 * 感想：一般般
 */
public class Day20_productExceptSelf {

    /**
     * 使用两个数组分别计算从左到右和从右到做的累积和，以时间换空间
     * 时间复杂度：O（n），空间复杂度：O（3n）
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null || nums.length == 0) return nums;
        /* 进行累积 */
        int[] left = new int[nums.length]; // left[i] = left[0] * left[1] .... left[i - 1];
        int[] right = new int[nums.length]; // right[i] = right[i + 1] * right[i + 2] ... right[i - 1];
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}