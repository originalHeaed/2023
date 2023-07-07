package month7;

/**
 * ʱ�䣺2023/7/6
 * ��������������һ����СΪ n ������ nums ���������еĶ���Ԫ�ء�
 *          ����Ԫ����ָ�������г��ִ��� ����  n/2  ��Ԫ�ء�
 *          ���ʱ�临�Ӷ�Ϊ O(n)���ռ临�Ӷ�Ϊ O(1) ���㷨
 * �����/���˼·��ʹ��ȡ�ɵķ���������Ԫ�ص�������Ԫ�ؼ���
 * ���룺����˼���������Խת��
 */
public class Day07_majorityElement {
    /**
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        /* ����������� */
        if (nums == null || nums.length == 0) return 0;
        /* ������Ԫ�ص�������Ԫ�� */
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