package month08;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2023/8/3
 * 问题描述：
 *  给定一个  无重复元素 的 有序 整数数组 nums 。
 *  返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *  列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *  "a->b" ，如果 a != b
 *  "a" ，如果 a == b
 * 切入点/解决思路：使用滑动窗口
 * 感想：简单偏上
 */
public class Day03_summaryRanges {

    /**
     * 时间复杂度：O（n），空间复杂度：O（n）
     */
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> arrayList = new ArrayList<>();
        /* 特殊情况处理 */
        if (nums == null || nums.length == 0) return new ArrayList<>();
        /* 使用滑动窗口 */
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] - 1 != nums[left]) {
                if (right - 1 == left) arrayList.add(String.valueOf(nums[left]));
                else arrayList.add(nums[left] + "->" + nums[right - 1]);
                left = right;
            }
            right++;
        }
        /* 最后一个区间的处理 */
        if (right - 1 == left) arrayList.add(String.valueOf(nums[left]));
        else arrayList.add(nums[left] + "->" + nums[right - 1]);
        return arrayList;
    }

}