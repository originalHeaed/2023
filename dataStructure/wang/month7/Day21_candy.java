package month7;

import java.util.Arrays;

/**
 * ʱ�䣺2023/7/21
 * ����������
 * n ������վ��һ�š�����һ���������� ratings ��ʾÿ�����ӵ����֡�
 * ����Ҫ��������Ҫ�󣬸���Щ���ӷַ��ǹ���
 * ÿ���������ٷ��䵽 1 ���ǹ���
 * ���������������ָ��ߵĺ��ӻ��ø�����ǹ���
 * �����ÿ�����ӷַ��ǹ������㲢������Ҫ׼���� �����ǹ���Ŀ ��
 * �����/���˼·��
 * ���룺�е�
 */
public class Day21_candy {
    /**
     * ʱ�临�Ӷȣ�O��n^2�����ռ临�Ӷȣ�O��n��
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        /* ����������� */
        if (ratings == null || ratings.length == 0) return 0;
        /* ��ʼ���� */
        int[] helper = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            helper[i] = 1;
        }
        for (int i = 0; i < ratings.length; i++) {
            /* �� i �������Ԫ��ֵ���� */
            int index = i - 1;
            while (index >= 0 && ratings[index] > ratings[index + 1]) {
                helper[index] = Math.max(helper[index + 1] + 1, helper[index]);
                index--;
            }
            /* �� i �ұߵ�����Ԫ�ظ��� */
            index = i + 1;
            while (index < ratings.length && ratings[index] > ratings[index - 1]) {
                helper[index] = Math.max(helper[index - 1] + 1, helper[index]);
                index++;
            }
        }
        /* ͳ����С���� */
        int total = 0;
        for (int i = 0; i < ratings.length; i++) {
            total += helper[i];
        }
        return total;
    }

    /**
     * ʹ�����α�������������ÿ������������Ҫ�����ǹ����ܹ�����Ҫ��
     *
     * @param ratings
     * @return
     */
    public int candy2(int[] ratings) {
        /* ����������� */
        if (ratings == null || ratings.length == 0) return 0;
        int[] helper = new int[ratings.length];
        Arrays.fill(helper, 1);
        /* �����ұ�������֤ÿ�����Ӷ���һ���������ں��ӣ�����ұߺ��ӷ��������ǹ�һ������ߺ����ǹ��� */
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) helper[i] = Math.max(helper[i - 1] + 1, helper[i]);
        }
        /* ���ҵ����������֤ÿ�����Ӷ�һ���ǹ��������ں��ӣ������ߺ��ӷ��������ǹ�һ�����ұߺ����ǹ��� */
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) helper[i] = Math.max(helper[i + 1] + 1, helper[i]);
        }
        /* ͳ�������ǹ� */
        int total = 0;
        for (int i = 0; i < helper.length; i++) {
            total += helper[i];
        }
        return total;
    }
}