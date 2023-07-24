package month7;

/**
 * ʱ�䣺2023/7/21
 * ����������
 *  ��һ����·���� n ������վ�����е� i ������վ������ gas[i] ����
 *  ����һ�������������޵ĵ��������ӵ� i ������վ������ i+1 ������վ��Ҫ�������� cost[i] ����������е�һ������վ��������ʼʱ����Ϊ�ա�
 *  ���������������� gas �� cost ���������԰�˳���ƻ�·��ʻһ�ܣ��򷵻س���ʱ����վ�ı�ţ����򷵻� -1 ��������ڽ⣬�� ��֤ ���� Ψһ �ġ�
 * �����/���˼·��ʹ��̰��˼��
 * ���룺��΢
 */
public class Day21_canCompleteCircuit {
    /**
     * ʹ�ñ���������ÿһ�����������һ��
     * ʱ�临�Ӷȣ�O��n^2��
     * �ռ临�Ӷȣ�O��n��
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /* ����������� */
        if (gas == null || cost == null || gas.length != cost.length || gas.length == 0) return -1;
        int[] helper = new int[gas.length]; // �� i �ż���վ�� i+1 �ż���վ������ʹ�� i �ż���վ���ͻ�ʣ�¶���
        for (int i = 0; i < gas.length; i++) {
            helper[i] = gas[i] - cost[i];
        }
        /* ѭ������ */
        for (int i = 0; i < helper.length; i++) {
            int count = 0;
            int index = i;
            do {
                count += helper[index];
                if (count < 0) break;
                index = (index + 1) % helper.length;
            } while (index != i);
            if (count >= 0) return i;
        }
        return -1;
    }

    /**
     * ����̰���㷨
     * �����Ƶ���ʹ��˫ָ�������Χ�ڵĺ�Ϊ��ֵ������ָ�����ƣ������Χ�ڵĺ�ֵΪ��ֵ����ָ�����ƣ�ѭ�����飩�������� left �� right ����
     * �ҷ�Χ�ڵ�ֵ֮�ʹ��ڵ��� 0 ���ʾ������ôһ������վ������ left ֵ�����򷵻� -1��
     * ʱ�临�Ӷȣ�O��n��
     * �ռ临�Ӷȣ�O��n��
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        /* ����������� */
        if (gas == null || cost == null || gas.length != cost.length || gas.length == 0) return -1;
        /* ѭ������ */
        int left = 0;
        int right = 0;
        int total = gas[left] - cost[left];
        do {
            int tem = 0;
            if (total >= 0) {
                right = (right + 1) % gas.length;
                tem = right;
            } else {
                left = left == 0 ? gas.length - 1 : left - 1;
                tem = left;
            }
            if (right != left) total += gas[tem] - cost[tem];
        } while (left != right);
        return total >= 0 ? left : -1;
    }

}