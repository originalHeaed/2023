package month7;

/**
 * 时间：2023/7/6
 * 问题描述：给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 *          多数元素是指在数组中出现次数 大于  n/2  的元素。
 *          设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法
 * 切入点/解决思路：使用取巧的方法，多数元素抵消少数元素即刻
 * 感想：有意思，类似与脑筋急转弯
 */
public class Day07_majorityElement {
    /**
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null || nums.length == 0) return 0;
        /* 将多数元素抵消少数元素 */
        int target = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == target) count++;
            else count--;
            if (count == 0) {
                target = nums[i];
                count = 1;
            }
        }
        return target;
    }
}