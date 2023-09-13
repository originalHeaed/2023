package month09;

import java.util.*;
import java.util.stream.Stream;

/**
 * ʱ�䣺2023/9/13
 * ����������
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰� ����˳�� ���ء�
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 * �����/���˼·��ʹ�������������
 * ���룺�е�
 */
public class Day13_letterCombinations {
    /**
     * �������
     */
    private List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new LinkedList<>();
        /* ����������� */
        if (digits == null || digits.length() == 0) return res;
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        Set<Character> next = new HashSet<>(); // ������������������м�¼�Ѿ����ʵ��ַ�
        getCombination(map, digits, 0, "");
        return res;
    }

    /**
     * ������������ҵ����е����
     */
    private void getCombination(Map<Character, char[]> map, String digit, int index, String sb) {
        /* �ݹ�������� */
        if (index == digit.length()) {
            res.add(sb);
            return;
        }
        /* ���еݹ� */
        char ele = digit.charAt(index);
        for (char c : map.get(ele)) {
            getCombination(map, digit, index + 1, sb + c);
        }
    }

}