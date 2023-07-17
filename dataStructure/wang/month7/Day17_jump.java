package month7;

/**
 * 时间：2023/7/17
 * 问题描述：给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *          每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。
 *          返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]
 * 切入点/解决思路：适用贪心算法 + 双指针
 * 感想：一般
 */
public class Day17_jump {
    /**
     * 使用贪心算法，每次跳的时候选择可选范围内下次能够跳的最远的一个位置，然后重复这个逻辑，就可以得到最少次数
     * 时间复杂度：O（n），空间复杂度：O（1）
     */
    public int jump(int[] nums) {
        int time = 0;
        /* 特殊情况处理 */
        if (nums == null || nums.length <= 1) return time;
        /* 使用贪心算法 */
        int left = 1; // 上传的 right + 1
        int right = nums[0]; // 下次跳转最远可以跳转的下标
        while (true) {
            time++;
            if (right >= (nums.length - 1)) break;
            int tem = 0;
            for (int i = left; i <= right; i++) {
                tem = Math.max(tem, nums[i] + i);
            }
            left = right + 1;
            right = tem;
        }
        return time;
    }

}