package month08;

/**
 * ʱ�䣺2023/8/7
 * ����������
 *  ����һ�� ���ص��� ������������ʼ�˵�����������б�
 *  ���б��в���һ���µ����䣬����Ҫȷ���б��е�������Ȼ�����Ҳ��ص�������б�Ҫ�Ļ������Ժϲ����䣩��
 * �����/���˼·��ֱ�Ӳ��뼴�ɣ��е������ڻ�������
 * ���룺�е�ƫ��
 */
public class Day07_insert {
    /**
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��n��
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /* ����������� */
        if (intervals == null || newInterval == null) return intervals;
        /* ��ʼ���� */
        int[][] temIntervals = new int[intervals.length + 1][2];
        int base = 0;
        int i = 0;
        while (i < intervals.length) {
            if (intervals[i][0] > newInterval[1]) {
                /* ����ϲ������������ڵ� i ��������� */
                temIntervals[base][0] = newInterval[0];
                temIntervals[base][1] = newInterval[1];
                base++;
                break;
            } else if (intervals[i][1] < newInterval[0]) {
                /* ����ϲ������������ڵ� i �������ұ� */
                temIntervals[base][0] = intervals[i][0];
                temIntervals[base][1] = intervals[i][1];
                base++;
                i++;
            } else {
                /* ��Ҫ�ϲ�������������� i ������ϲ����γ��µ������� */
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
        }
        if (i == intervals.length) {
            temIntervals[base][0] = newInterval[0];
            temIntervals[base][1] = newInterval[1];
            base++;
        } else {
            for (; i < intervals.length; i++, base++) {
                temIntervals[base][0] = intervals[i][0];
                temIntervals[base][1] = intervals[i][1];
            }
        }
        /* ��������вü���ȥ��ֵΪ�յĲ��� */
        int[][] res = new int[base][2];
        for (int j = 0; j < res.length; j++) {
            res[j][0] = temIntervals[j][0];
            res[j][1] = temIntervals[j][1];
        }
        return res;
    }
}