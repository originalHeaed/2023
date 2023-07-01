package month7;

/**
 * ʱ�䣺2023/7/1
 * ��������������һ������ nums ��һ��ֵ val������Ҫ ԭ�� �Ƴ�������ֵ���� val ��Ԫ�أ��������Ƴ���������³��ȡ�
 *         ��Ҫʹ�ö��������ռ䣬������ʹ�� O(1) ����ռ䲢 ԭ�� �޸��������顣
 *         Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * �����/���˼·��ʹ��˫ָ��(����ָ�� / ��βָ�룩
 * ���룺С��˼
 */
public class Day01_RemoveElement {
    public int removeElement(int[] nums, int val) {
        /* ����������� */
        if (nums == null || nums.length == 0) return 0;
        /* ʹ��˫ָ����н��� */
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != val) nums[left++] = nums[right];
            right++;
        }
        return left;
    }

    public int removeElement2(int[] nums, int val) {
        /* ����������� */
        if (nums == null || nums.length == 0) return 0;
        /* ʹ��˫ָ����н��� */
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            /* ���������ҵ���һ���� val ��Ԫ���±� */
            while (left <= right && nums[right] == val) right--;
            /* ���������ҵ���һ�� val Ԫ�ص��±� */
            while (left <= right && nums[left] != val) left++;
            if (left <= right) {
                nums[left] = nums[right];
                nums[right] = val;
            }
        }
        return left;
    }

}