package month7;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间：2023/7/27
 * 问题描述：
 * 切入点/解决思路：
 * 感想：一般
 */
public class Day27_twoSum {
    /**
     * 时间复杂度：O（n），空间复杂度：O（n）
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        /* 特殊情况考虑 */
        if (numbers == null || numbers.length < 2) return new int[2];
        /* 使用 map 来保存已经保留的 */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]) + 1, i + 1};
            }
            map.put(target - numbers[i], i);
        }
        return new int[2];
    }

    /**
     * 使用二分法来完成
     * 时间复杂度：O（nlogn），空间复杂度：O（1）
     */
    public int[] twoSum2(int[] numbers, int target) {
        /* 特殊情况考虑 */
        if (numbers == null || numbers.length < 2) return new int[2];
        /* 使用二分法查找 */
        for (int i = 0; i < numbers.length - 1; i++) {
            int exist = isExist(i + 1, target - numbers[i], numbers);
            if (exist != -1) return new int[]{i + 1, exist + 1};
        }
        return new int[2];
    }

    /**
     * 使用二分法查找元素
     */
    private int isExist(int left, int target, int[] number) {
        int l = left;
        int r = number.length - 1;
        while (l < r) {
            int mid = (r + l) / 2;
            if (number[mid] == target) return mid;
            if (number[mid] < target) l = mid + 1; // 可以保证 l 始终在数组范围内
            if (number[mid] > target) r = mid - 1;
        }
        return number[l] == target ? l : -1;
    }

    /**
     * 使用双指针方法
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    public int[] twoSum3(int[] numbers, int target) {
        /* 特殊情况考虑 */
        if (numbers == null || numbers.length < 2) return new int[2];
        /* 使用双指针方法 */
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int tem = target - numbers[left];
            while (left < right && tem < numbers[right]) right--;
            if (left < right && tem == numbers[right]) return new int[]{left + 1, right + 1};
            else left++;
        }
        return new int[2];
    }

}