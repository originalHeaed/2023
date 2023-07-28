package month7;

import java.util.Map;

/**
 * ʱ�䣺2023/7/28
 * ����������
 *  ����һ������Ϊ n ���������� height ���� n �����ߣ��� i ���ߵ������˵��� (i, 0) �� (i, height[i]) ��
 *  �ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
 *  �����������Դ�������ˮ����
 *  ˵�����㲻����б������
 * �����/���˼·��ʹ��˫ָ�룬��βָ��
 * ���룺�е�
 */
public class Day28_maxArea {
    /**
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��1��
     */
    public int maxArea(int[] height) {
        /* ����������� */
        if (height == null || height.length <= 1) return 0;
        /* ��ʼ�������� */
        int head = 0;
        int tail = height.length - 1;
        int capacity = 0;
        while (head != tail) {
            capacity = Math.max(capacity, (tail - head) * Math.min(height[head], height[tail]));
            if (height[head] > height[tail]) tail--;
            else head++;
        }
        return capacity;
    }
}