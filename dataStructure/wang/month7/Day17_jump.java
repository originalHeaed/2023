package month7;

/**
 * ʱ�䣺2023/7/17
 * ��������������һ������Ϊ n �� 0 ������������ nums����ʼλ��Ϊ nums[0]��
 *          ÿ��Ԫ�� nums[i] ��ʾ������ i ��ǰ��ת����󳤶ȡ�
 *          ���ص��� nums[n - 1] ����С��Ծ���������ɵĲ����������Ե��� nums[n - 1]
 * �����/���˼·������̰���㷨 + ˫ָ��
 * ���룺һ��
 */
public class Day17_jump {
    /**
     * ʹ��̰���㷨��ÿ������ʱ��ѡ���ѡ��Χ���´��ܹ�������Զ��һ��λ�ã�Ȼ���ظ�����߼����Ϳ��Եõ����ٴ���
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��1��
     */
    public int jump(int[] nums) {
        int time = 0;
        /* ����������� */
        if (nums == null || nums.length <= 1) return time;
        /* ʹ��̰���㷨 */
        int left = 1; // �ϴ��� right + 1
        int right = nums[0]; // �´���ת��Զ������ת���±�
        while (true) {
            time++;
            if (right >= (nums.length - 1)) break;
            int tem = 0;
            for (int i = left; i <= right; i++) {
                tem = Math.max(tem, nums[i] + i);
            }
            left = right + 1;
            right = tem;
        }
        return time;
    }

}