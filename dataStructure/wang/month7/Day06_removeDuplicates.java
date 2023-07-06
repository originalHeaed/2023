package month7;

/**
 * ʱ�䣺2023/7/5
 * ��������������һ���������� nums ������ ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹ�ó��ִ����������ε�Ԫ��ֻ�������� ������ɾ����������³��ȡ�
 * �����/���˼·��˫ָ�� - ����ָ��
 * ���룺�е���˼
 */
public class Day06_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        /* ����������� */
        if (nums.length <= 2) return nums.length;
        /* ʹ�ÿ���ָ�� */
        int count = 1; // Ԫ���Ѿ���ʹ�ö��ٴ���
        int slow = 1;
        int fast = 1;
        while (fast < nums.length) {
            /* ͳ�Ƶ�ǰ��ָ����ָ��Ԫ�ر��ռ��Ĵ��� */
            if (nums[fast] != nums[slow - 1]) {
                count = 1;
            } else {
                count++;
            }
            /* ֻ�е�ǰ��ָ�뱻�ռ��Ĵ���С�ڵ��� 2 ʱ����ʾ��Ԫ�ػ���Ҫ���ռ��� */
            if (count <= 2) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}