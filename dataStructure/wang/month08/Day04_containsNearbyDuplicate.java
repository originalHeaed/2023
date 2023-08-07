package month08;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间：2023/8/4
 * 问题描述：
 *  给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 *  满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * 切入点/解决思路：使用 map
 * 感想：简单偏上
 */
public class Day04_containsNearbyDuplicate {
    /**
     * 时间复杂度：O（n），空间复杂度：O（n）
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /* 特殊情况处理 */
        if (nums == null || k == 0 || nums.length <= k) return false;
        /* 使用 map */
        Map<Integer, Integer> map = new HashMap<>(); // 表示目标元素和目标元素最近的下标
        for (int i = 0; i < nums.length; i++) {
            /* 存在 num[i] == num[j] 且 I - j <= k */
            if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) return true;
            map.put(nums[i], i); // 更新该元素最新的下标
        }
        return false;
    }
}