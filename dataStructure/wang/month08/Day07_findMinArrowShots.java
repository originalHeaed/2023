package month08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ʱ�䣺2023/8/7
 * ����������
 * ��һЩ������������һ���� XY ƽ���ʾ��ǽ���ϡ�ǽ���ϵ������¼���������� points ��
 * ����points[i] = [xstart, xend] ��ʾˮƽֱ���� xstart �� xend֮��������㲻֪�������ȷ�� y ���ꡣ
 * һ֧������������ x ��Ӳ�ͬ�� ��ȫ��ֱ ������������� x �����һ֧��������һ�������ֱ���Ŀ�ʼ�ͽ�������Ϊ xstart��xend��
 * ������  xstart �� x �� xend���������ᱻ ���� ����������Ĺ��������� û������ �� ����һ�������֮�󣬿������޵�ǰ����
 * ����һ������ points ����������������������������� ��С ������ ��
 * �����/���˼·�������� + ̰�ģ�ȡ����
 * ���룺�е�
 */
public class Day07_findMinArrowShots {
    /**
     * ʱ�临�Ӷȣ�O��nlogn�����ռ临�Ӷȣ�O��n��
     */
    public int findMinArrowShots(int[][] points) {
        /* ����������� */
        if (points == null) return 0;
        /* ��ȡԪ��֮�佻�� */
        Arrays.sort(points, Comparator.comparingInt(val -> val[0])); // ��ÿ��������ߵ�ֵ������������
        int total = 1;
        int left = points[0][0];
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            /* ������һ�������ı߽磬���㵱ǰ�����ܷ�����һ�������б����� */
            if (points[i][0] > right) {
                /* ���ܣ������ý�����Χ */
                left = points[i][0];
                right = points[i][1];
                total++;
            } else {
                /* ���ԣ�����½�����Χ */
                left = Math.max(left, points[i][0]);
                right = Math.min(right, points[i][1]);
            }
        }
        return total;
    }
}