package month7;

import java.util.Arrays;
import java.util.Map;

/**
 * ʱ�䣺2023/7/7
 * ��������������һ���������� nums���������е�Ԫ��������ת k ��λ�ã����� k �ǷǸ�����
 * �����/���˼·��ֱ��Ų�����˵����ڲ���ʹ�� for ѭ��һ��һ�����ƶ� k ������Ϊ���ܻ���ںܶ����õ�Ų��
 * ���룺��һ�������˼
 */
public class Day07_rotate {
    /**
     * ��������ʱ�临�Ӷȣ�O��nk����k ���ܳ�����
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        /* ����������� */
        if (nums == null || nums.length == 0 || (k % nums.length) == 0) return;
        /* ��ʼһ����λ */
        for (int i = 0; i < k; i++) {
            int val = nums[0];
            for (int j = 0; j < nums.length; j++) {
                int tem = nums[(j + 1) % nums.length];
                nums[(j + 1) % nums.length] = val;
                val = tem;
            }
        }
    }

    /**
     * ���������Ż� 1��ʱ�临�Ӷȣ�O��n*��k%n������ʱ�临�ӶȽ��� O��n^2������� O��n*��n-1����
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        /* ����������� */
        if (nums == null || nums.length == 0 || (k % nums.length) == 0) return;
        /* ��ʼһ����λ */
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int val = nums[0];
            for (int j = 0; j < nums.length; j++) {
                int tem = nums[(j + 1) % nums.length];
                nums[(j + 1) % nums.length] = val;
                val = tem;
            }
        }
    }

    /**
     * ���������Ż� 2��ʱ�临�Ӷȣ�O��n *��k%n������ʱ�临�ӶȽ��� O��n^2������� O��n*��n/2����
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        /* ����������� */
        if (nums == null || nums.length == 0 || (k % nums.length) == 0) return;
        /* ��ʼһ����λ */
        k = k % nums.length;
        if (k > (nums.length / 2)) {
            /* ���ƶ� */
            k = nums.length - k;
            for (int i = 0; i < k; i++) {
                int val = nums[0];
                for (int j = nums.length; j > 0; j++) {
                    int tem = nums[(j - 1) % nums.length];
                    nums[(j - 1) % nums.length] = val;
                    val = tem;
                }
            }
        } else {
            /* ���ƶ� */
            for (int i = 0; i < k; i++) {
                int val = nums[0];
                for (int j = 0; j < nums.length; j++) {
                    int tem = nums[(j + 1) % nums.length];
                    nums[(j + 1) % nums.length] = val;
                    val = tem;
                }
            }
        }
    }

    /**
     * ʹ�ÿռ任ʱ�䣬��ʱ�临�ӶȽ��͵� O��n�������ռ临�Ӷȼӱ� O��2n��
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        /* ����������� */
        if (nums == null || nums.length == 0 || (k % nums.length) == 0) return;
        /* ��ʼ����Ų�� */
        k = k % nums.length;
        int[] helper = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < helper.length; i++) {
            nums[(i + k) % nums.length] = helper[i];
        }
    }

    /**
     * ԭ���޸ģ�ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��1��
     * @param nums
     * @param k
     */
    public void rotate5(int[] nums, int k) {
        /* ����������� */
        if (nums == null || nums.length == 0 || (k % nums.length) == 0) {
            return;
        }
        /* ��ʼ����Ų�� */
    }
}