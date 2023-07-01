package month7;

import jdk.nashorn.internal.codegen.SpillObjectCreator;

/**
 * ʱ�䣺2023/7/1
 * �������������������� �ǵݼ�˳�� ���е��������� nums1 �� nums2�������������� m �� n ���ֱ��ʾ nums1 �� nums2 �е�Ԫ����Ŀ��
 *      ����ϲ� nums2 �� nums1 �У�ʹ�ϲ��������ͬ���� �ǵݼ�˳�� ���С�
 * �����/���˼·��ʹ��˫ָ�� + �����������β����ʼ�ϲ�����
 * ���룺С��˼
 */
public class Day01_merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /* ����������� */
        if (nums2 == null | nums2 == null || nums1.length != (m + n)) return;
        /* ʹ��˫ָ�뿪ʼ�ϲ� */
        int point1 = m - 1;
        int point2 = n - 1;
        int index = m + n -1;
        while (point1 >= 0 && point2 >= 0) {
            if (nums1[point1] > nums2[point2]) nums1[index--] = nums1[point1--];
            else nums1[index--] = nums2[point2--];
        }
        while (point2 >= 0) {
            nums1[index--] = nums2[point2--];
        }
     }
}