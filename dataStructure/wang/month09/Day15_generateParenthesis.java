package month09;

import java.util.LinkedList;
import java.util.List;

/**
 * ʱ�䣺2023/9/15
 * �������������� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
 * �����/���˼·��ʹ�û��ݵķ�ʽ
 * ���룺�е�
 */
public class Day15_generateParenthesis {
    /**
     * ������
     */
    private List<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        helper(new LinkedList<>(), n, 0);
        return res;
    }

    /**
     * left ʣ�����ʹ�õ�����������
     * right ʣ����Ҫ�������������
     */
    private void helper(List<Character> list, int left, int right) {
        /* �ݹ�������� */
        if (left == 0 && right == 0) {
            StringBuilder sb = new StringBuilder();
            list.stream().forEach(ele -> sb.append(ele));
            res.add(sb.toString());
            return;
        }
        /* �ݹ��� */
        if (left > 0) {
            list.add('(');
            helper(list, left - 1, right + 1);
            list.remove(list.size() - 1);
        }
        if (right > 0) {
            list.add(')');
            helper(list, left, right - 1);
            list.remove(list.size() - 1);
        }
    }
}