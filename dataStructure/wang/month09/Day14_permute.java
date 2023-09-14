package month09;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * ʱ�䣺2023/9/14
 * ����������
 *  ����һ�������ظ����ֵ����� nums �������� ���п��ܵ�ȫ���� ������� ������˳�� ���ش𰸡�
 * �����/���˼·��ʹ�������������
 * ���룺�е�
 */
public class Day14_permute {
    private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        /* ����������� */
        if (nums == null || nums.length == 0) return res;
        /* �ݹ鴦�� */
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        helper(set, new LinkedList<>());
        return res;
    }

    private void helper(Set<Integer> container, List<Integer> list) {
        /* �ݹ�������� */
        if (container.isEmpty()) res.add(new LinkedList<>(list));
        /* ���еݹ� */
        Set<Integer> copy = new HashSet<>(container);
        copy.stream().forEach(ele -> {
            container.remove(ele);
            list.add(ele);
            helper(container, list);
            container.add(ele);
            list.remove(ele);
        });
    }

}