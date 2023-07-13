package month7;

/**
 * 时间：2023/7/13
 * 问题描述：给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *          数组中的每个元素代表你在该位置可以跳跃的最大长度 。
 *          判断你是否能够到达最后一个下标。
 * 切入点/解决思路：使用动态规划，dp[i] = Max(dp[i - 1], i + num[i] ), dp[i] 表示从 [0, i] 之间任意一个元素开始跳可以跳到的最远元素下标
 * 感想：
 */
public class Day13_canJump {
    public boolean canJump(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null || nums.length <= 1) return true;
        if (nums[0] <= 0) return false;
        /* 获取是否可以达到最后一个 */
        int index = 1;
        while (index < nums.length) {
            nums[index] = Math.max(nums[index - 1], index + nums[index]);
            if (nums[index] >= (nums.length - 1)) return true;
            if (nums[index] == index) break; // [0, index] 最远能访问的下标只到 index，终止循环
            index++;
        }
        return false;
    }
}