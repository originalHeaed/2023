package month08;

import java.util.HashMap;
import java.util.Map;

/**
 * ʱ�䣺2023/8/4
 * ����������
 *  ����һ���������� nums ��һ������ k ���ж��������Ƿ�������� ��ͬ������ i �� j ��
 *  ���� nums[i] == nums[j] �� abs(i - j) <= k ��������ڣ����� true �����򣬷��� false ��
 * �����/���˼·��ʹ�� map
 * ���룺��ƫ��
 */
public class Day04_containsNearbyDuplicate {
    /**
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��n��
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /* ����������� */
        if (nums == null || k == 0 || nums.length <= k) return false;
        /* ʹ�� map */
        Map<Integer, Integer> map = new HashMap<>(); // ��ʾĿ��Ԫ�غ�Ŀ��Ԫ��������±�
        for (int i = 0; i < nums.length; i++) {
            /* ���� num[i] == num[j] �� I - j <= k */
            if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) return true;
            map.put(nums[i], i); // ���¸�Ԫ�����µ��±�
        }
        return false;
    }
}