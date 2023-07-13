package month7;

/**
 * ʱ�䣺2023/7/13
 * ��������������һ���Ǹ��������� nums �������λ������� ��һ���±� ��
 *          �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶� ��
 *          �ж����Ƿ��ܹ��������һ���±ꡣ
 * �����/���˼·��ʹ�ö�̬�滮��dp[i] = Max(dp[i - 1], i + num[i] ), dp[i] ��ʾ�� [0, i] ֮������һ��Ԫ�ؿ�ʼ��������������ԶԪ���±�
 * ���룺
 */
public class Day13_canJump {
    public boolean canJump(int[] nums) {
        /* ����������� */
        if (nums == null || nums.length <= 1) return true;
        if (nums[0] <= 0) return false;
        /* ��ȡ�Ƿ���Դﵽ���һ�� */
        int index = 1;
        while (index < nums.length) {
            nums[index] = Math.max(nums[index - 1], index + nums[index]);
            if (nums[index] >= (nums.length - 1)) return true;
            if (nums[index] == index) break; // [0, index] ��Զ�ܷ��ʵ��±�ֻ�� index����ֹѭ��
            index++;
        }
        return false;
    }
}