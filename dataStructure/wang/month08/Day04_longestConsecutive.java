package month08;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ʱ�䣺2023/8/4
 * ����������
 *  ����һ��δ������������� nums ���ҳ���������������У���Ҫ������Ԫ����ԭ�������������ĳ��ȡ�
 *  ������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ O(n) ���㷨��������⡣
 * �����/���˼·��
 * ���룺
 */
public class Day04_longestConsecutive {

    /**
     * ʹ������ķ�ʽ
     * ʱ�临�Ӷȣ�O��nlogn��
     */
    public int longestConsecutive(int[] nums) {
        /* ����������� */
        if (nums == null || nums.length == 0) return 0;
        /* ��ʼ���� */
        Arrays.sort(nums);
        int total = 1;
        int tem = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                total = Math.max(total ,tem);
                tem = 1;
            } else if (nums[i] != nums[i - 1]) tem++;
        }
        total = Math.max(total ,tem);
        return total;
    }

    /**
     * ʹ�� map
     * ʱ�临�Ӷȣ�O��n��
     */
    public int longestConsecutive2(int[] nums) {
        /* ����������� */
        if (nums == null || nums.length == 0) return 0;
        /* ��ʼ���� */
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(val -> set.add(val));
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int temLongest = 1;
                int val = nums[i] + 1;
                while (set.contains(val)) {
                    val++;
                    temLongest++;
                }
                longest = Math.max(temLongest, longest);
            }
        }
        return longest;
    }

}