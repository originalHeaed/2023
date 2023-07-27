package month7;

import java.util.HashMap;
import java.util.Map;

/**
 * ʱ�䣺2023/7/27
 * ����������
 * �����/���˼·��
 * ���룺һ��
 */
public class Day27_twoSum {
    /**
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��n��
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        /* ����������� */
        if (numbers == null || numbers.length < 2) return new int[2];
        /* ʹ�� map �������Ѿ������� */
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
     * ʹ�ö��ַ������
     * ʱ�临�Ӷȣ�O��nlogn�����ռ临�Ӷȣ�O��1��
     */
    public int[] twoSum2(int[] numbers, int target) {
        /* ����������� */
        if (numbers == null || numbers.length < 2) return new int[2];
        /* ʹ�ö��ַ����� */
        for (int i = 0; i < numbers.length - 1; i++) {
            int exist = isExist(i + 1, target - numbers[i], numbers);
            if (exist != -1) return new int[]{i + 1, exist + 1};
        }
        return new int[2];
    }

    /**
     * ʹ�ö��ַ�����Ԫ��
     */
    private int isExist(int left, int target, int[] number) {
        int l = left;
        int r = number.length - 1;
        while (l < r) {
            int mid = (r + l) / 2;
            if (number[mid] == target) return mid;
            if (number[mid] < target) l = mid + 1; // ���Ա�֤ l ʼ�������鷶Χ��
            if (number[mid] > target) r = mid - 1;
        }
        return number[l] == target ? l : -1;
    }

    /**
     * ʹ��˫ָ�뷽��
     * ʱ�临�Ӷȣ�O��n��
     * �ռ临�Ӷȣ�O��1��
     */
    public int[] twoSum3(int[] numbers, int target) {
        /* ����������� */
        if (numbers == null || numbers.length < 2) return new int[2];
        /* ʹ��˫ָ�뷽�� */
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