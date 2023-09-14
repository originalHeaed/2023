package month09;

import java.util.*;

/**
 * ʱ�䣺2023/9/14
 * ����������
 *  ����һ�� ���ظ�Ԫ�� ���������� candidates ��һ��Ŀ������ target ���ҳ� candidates �п���ʹ���ֺ�ΪĿ���� target �� ���� ��ͬ��� �������б���ʽ���ء�����԰� ����˳�� ������Щ��ϡ�
 *  candidates �е� ͬһ�� ���ֿ��� �������ظ���ѡȡ ���������һ�����ֵı�ѡ������ͬ������������ǲ�ͬ�ġ�
 *  ���ڸ��������룬��֤��Ϊ target �Ĳ�ͬ��������� 150 ����
 * �����/���˼·��ʹ�õݹ�˼��
 * ���룺�е�
 */
public class Day14_combinationSum {
    /**
     * ��������
     */
    private List<List<Integer>> res = new LinkedList<>();

    /**
     * ʱ�临�Ӷȣ�O��n!��
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(candidates, new Stack<>(), 0, target);
        return res;
    }

    private void helper(int[] candidates, Stack<Integer> stack, int idx, int sum) {
        /* �ݹ�������� */
        if (sum == 0) {
            res.add(new LinkedList<>(stack));
            return;
        }
        if (idx >= candidates.length || sum < candidates[idx]) return;
        /* �ݹ��� */
        /* ������ǰ���� */
        helper(candidates, stack, idx + 1, sum);
        /* ѡ��ǰ���� */
        stack.push(candidates[idx]);
        helper(candidates, stack, idx, sum - candidates[idx]);
        stack.pop();
    }

    public static void main(String[] args) {
        Day14_combinationSum sum = new Day14_combinationSum();
        sum.combinationSum(new int[]{7, 2,3,6}, 7);
    }

}