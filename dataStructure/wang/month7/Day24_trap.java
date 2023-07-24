package month7;

/**
 * ʱ�䣺2023/7/24
 * ����������
 *     ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 * �����/���˼·�����Ի�ˮ�����������½����������ſ����γɻ�ˮ�������������������ȥѰ�Ҿ��У���ʹ��˫ָ�룩
 * ���룺����
 */
public class Day24_trap {
    /**
     * �ҵ���ߵ�
     * ����ߵ������ҵ��θߵ㣬��������֮����Ի�ˮ��С��Ȼ�󽫴θߵ���Ϊ��ߵ㣬���ν���ֱ������߽磻
     * ����ߵ������ҵ��θߵ㣬��������֮����Ի�ˮ��С��Ȼ�󽫴θߵ���Ϊ��ߵ㣬�ظ��������ֱ�����ұ߽磻
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��n��
     */
    public int trap(int[] height) {
        /* ����������� */
        if (height == null || height.length <= 2) return 0;
        /* ������Ի��۶�����ˮ */
        int[] leftHelper = new int[height.length]; // i Ԫ����߸߶���ߵ�Ԫ���±�
        int[] rightHelper = new int[height.length]; // i Ԫ���ұ߸߶���ߵ�Ԫ���±�
        int index = 0; // ������������ߵ�Ԫ���±�
        int total = 0;
        /* ��ȡ [0, i) ���߶��±꣬��¼�� leftHelper[i] */
        leftHelper[0] = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[index] < height[i]) index = i;
            leftHelper[i] = height[i - 1] > height[leftHelper[i - 1]] ? i - 1 : leftHelper[i - 1]; // ������ʹ�� >=
        }
        leftHelper[0] = -1;
        /* ��ȡ (i, height.length - 1] ���߶��±꣬��¼�� rightHelper[i] */
        rightHelper[rightHelper.length - 1] = rightHelper.length - 1;
        for (int i = height.length - 2; i >= 0; i--) {
            rightHelper[i] = height[i + 1] > height[rightHelper[i + 1]] ? i + 1 : rightHelper[i + 1]; // ���������� >=
        }
        rightHelper[rightHelper.length - 1] = -1;
        /* ����ߵ㿪ʼ�󣬼�����ߵ㵽�θߵ��ˮ������Ȼ���ظ�������裬ֱ����߽� */
        int leftIndex = index;
        while (leftHelper[leftIndex] != -1) {
            int shortest = Math.min(height[leftIndex], height[leftHelper[leftIndex]]);
            for (int i = leftHelper[leftIndex]; i <= leftIndex ; i++) {
                total += shortest > height[i] ? shortest - height[i] : 0;
            }
            leftIndex = leftHelper[leftIndex];
        }
        /* ����ߵ㿪ʼ���ң�������ߵ㵽�θߵ��ˮ������Ȼ���ظ�������裬ֱ���ұ߽� */
        int rightIndex = index;
        while (rightHelper[rightIndex] != -1) {
            int shortest = Math.min(height[rightIndex], height[rightHelper[rightIndex]]);
            for (int i = rightIndex; i <= rightHelper[rightIndex]; i++) {
                total += shortest > height[i] ? shortest - height[i] : 0;
            }
            rightIndex = rightHelper[rightIndex];
        }
        return total;
    }
}