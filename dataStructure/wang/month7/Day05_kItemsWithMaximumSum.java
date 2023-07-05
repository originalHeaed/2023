package month7;

/**
 * ʱ�䣺2023/7/5
 * ����������������װ��һЩ��Ʒ��ÿ����Ʒ�϶���������� 1 ��0 �� -1 �������ĸ��Ǹ����� numOnes ��numZeros ��numNegOnes �� k ��
 *      �ּƻ�����Щ��Ʒ��ǡ��ѡ�� k ����Ʒ���������п��з����У���Ʒ�����������֮�͵����ֵ��
 * �����/���˼·��̰�ģ�ÿ�ζ�ѡ���ģ�
 * ���룺
 */
public class Day05_kItemsWithMaximumSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) return k;
        if (k <= (numOnes + numZeros)) return numOnes;
        return numOnes - (k - numOnes - numZeros);
    }
}