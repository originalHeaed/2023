package month7;

/**
 * ʱ�䣺2023/7/1
 * ��������������һ�� �������� ������ nums ������ ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹÿ��Ԫ�� ֻ����һ�� ��
 *      ����ɾ����������³��ȡ�Ԫ�ص� ���˳�� Ӧ�ñ��� һ�� ��Ȼ�󷵻� nums ��ΨһԪ�صĸ�����
 * �����/���˼·��˫ָ�� - ����ָ��
 * ���룺��΢�е���˼
 */
public class Day01_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        /* ����������� */
        if (nums == null) return -1;
        if (nums.length <= 1) return nums.length;
        /* ʹ�ÿ���ָ�� */
        int index = 1;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) nums[index++] = nums[fast];
            fast++;
        }
        return index;
    }

    public int removeDuplicates2(int[] nums) {
        /* ����������� */
        if (nums == null) return -1;
        /* ʹ�ÿ���ָ�� */
        int wife = 0;
        int husband = 1;
        while (husband < nums.length) {
            if (nums[wife] != nums[husband]) nums[wife++ + 1] = nums[husband];
            husband++;
        }
        return wife;
    }

}