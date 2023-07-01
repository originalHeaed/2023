package month7;

/**
 * 时间：2023/7/1
 * 问题描述：给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *         不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *         元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 切入点/解决思路：使用双指针(快慢指针 / 首尾指针）
 * 感想：小意思
 */
public class Day01_RemoveElement {
    public int removeElement(int[] nums, int val) {
        /* 特殊情况处理 */
        if (nums == null || nums.length == 0) return 0;
        /* 使用双指针进行交换 */
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != val) nums[left++] = nums[right];
            right++;
        }
        return left;
    }

    public int removeElement2(int[] nums, int val) {
        /* 特殊情况处理 */
        if (nums == null || nums.length == 0) return 0;
        /* 使用双指针进行交换 */
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            /* 从右向左找到第一个非 val 的元素下标 */
            while (left <= right && nums[right] == val) right--;
            /* 从左向右找到第一个 val 元素的下标 */
            while (left <= right && nums[left] != val) left++;
            if (left <= right) {
                nums[left] = nums[right];
                nums[right] = val;
            }
        }
        return left;
    }

}