package month7;

import java.util.Arrays;

/**
 * ʱ�䣺2023/7/18
 * ��������������һ���������� citations ������ citations[i] ��ʾ�о��ߵĵ� i ƪ���ı����õĴ��������㲢���ظ��о��ߵ� hָ����
 *         ����ά���ٿ���h ָ���Ķ��壺h ���������ô����� ��һ��������Ա�� h ָ�� ��ָ�����������ٷ����� h ƪ���ģ�����ÿƪ���� ���� ������ h �Ρ�
 *         ��� h �ж��ֿ��ܵ�ֵ��h ָ�� �����������Ǹ���
 * �����/���˼·��ʹ�ö��������¼����
 * ���룺�е���˼
 */
public class Day18_hIndex {
    /**
     * ʱ�临�Ӷȣ�O��1000n��
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        /* ����������� */
        if (citations == null || citations.length == 0) return 0;
        // �±��ʾ����������ֵ��ʾ����������Ϊ i ʱ�����ô������ڵ��� i ������������
        // Ϊʲôʹ�� 1000����Ϊÿƪ������ߵ����ô���Ϊ 1000��Ҳ����˵ h ֵ���Ҳ���� 1000�����û��Ҫͳ��
        // Ϊʲô + 1�����������㣬i ����ֱ�Ӵ�����������
        int[] count = new int[1000 + 1];
        for (int i = 0; i < citations.length; i++) {
            for (int j = 0; j <= citations[i]; j++) {
                count[j]++;
            }
        }
        /* ��ȡ���� h ֵ */
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] >= i) return i;
        }
        return 0;
    }

    /**
     * ʱ�临�Ӷȣ�O��nlogn��
     * ʹ�������㷨
     */
    public int hIndex2(int[] citations) {
        /* ����������� */
        if (citations == null || citations.length == 0) return 0;
        /* ����Ȼ��ͳ�� */
        Arrays.sort(citations); // ����֮��Ϊ����
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if(citations[i] > count) count++;
            else break;
        }
        return count;
    }

    /**
     * ʱ�临�Ӷȣ�O��n + m�� n - ��������ֵ��m - �������Ĵ���
     * ʹ�������㷨
     */
    public int hIndex3(int[] citations) {
        /* ����������� */
        if (citations == null || citations.length == 0) return 0;
        /* ͳ��ÿ�ַ����������������� */
        int[] helper = new int[1001]; // �Կռ任ʱ�䣬��������
        for (int i = 0; i < citations.length; i++) {
            helper[citations[i]]++;
        }
        int count = 0;
        int index = helper.length - 1;
        while (index >= 0 && count < helper.length) {
            while (helper[index] > 0 && index > count){
                count++;
                helper[index]--;
            }
            index--;
        }
        return count;
    }


}