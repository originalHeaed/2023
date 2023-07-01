package month7;

/**
 * 时间：2023/7/1
 * 问题描述：给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 *      返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * 切入点/解决思路：双指针 - 快慢指针
 * 感想：稍微有点意思
 */
public class Day01_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null) return -1;
        if (nums.length <= 1) return nums.length;
        /* 使用快慢指针 */
        int index = 1;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) nums[index++] = nums[fast];
            fast++;
        }
        return index;
    }

    public int removeDuplicates2(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null) return -1;
        /* 使用快慢指针 */
        int wife = 0;
        int husband = 1;
        while (husband < nums.length) {
            if (nums[wife] != nums[husband]) nums[wife++ + 1] = nums[husband];
            husband++;
        }
        return wife;
    }

}