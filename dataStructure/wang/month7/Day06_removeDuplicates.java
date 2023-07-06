package month7;

/**
 * 时间：2023/7/5
 * 问题描述：给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 切入点/解决思路：双指针 - 快慢指针
 * 感想：有点意思
 */
public class Day06_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        /* 特殊情况处理 */
        if (nums.length <= 2) return nums.length;
        /* 使用快慢指针 */
        int count = 1; // 元素已经被使用多少次了
        int slow = 1;
        int fast = 1;
        while (fast < nums.length) {
            /* 统计当前快指针所指的元素被收集的次数 */
            if (nums[fast] != nums[slow - 1]) {
                count = 1;
            } else {
                count++;
            }
            /* 只有当前快指针被收集的次数小于等于 2 时，表示该元素还需要被收集， */
            if (count <= 2) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}