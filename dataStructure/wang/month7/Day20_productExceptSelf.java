package month7;

/**
 * ʱ�䣺2023/7/20
 * ����������
 *  ����һ���������� nums������ ���� answer ������ answer[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻� ��
 *  ��Ŀ���� ��֤ ���� nums֮������Ԫ�ص�ȫ��ǰ׺Ԫ�غͺ�׺�ĳ˻�����  32 λ ������Χ�ڡ�
 *  �벻Ҫʹ�ó��������� O(n) ʱ�临�Ӷ�����ɴ��⡣
 * �����/���˼·��ʹ�ÿռ任ʱ��
 * ���룺һ���
 */
public class Day20_productExceptSelf {

    /**
     * ʹ����������ֱ��������Һʹ��ҵ������ۻ��ͣ���ʱ�任�ռ�
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��3n��
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        /* ����������� */
        if (nums == null || nums.length == 0) return nums;
        /* �����ۻ� */
        int[] left = new int[nums.length]; // left[i] = left[0] * left[1] .... left[i - 1];
        int[] right = new int[nums.length]; // right[i] = right[i + 1] * right[i + 2] ... right[i - 1];
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}