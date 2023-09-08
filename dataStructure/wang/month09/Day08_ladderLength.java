package month09;

import java.util.*;

/**
 * ʱ�䣺2023/9/8
 * ����������
 *  �ֵ� wordList �дӵ��� beginWord �� endWord �� ת������ ��һ������������γɵ����� beginWord -> s1 -> s2 -> ... -> sk��
 *  ÿһ�����ڵĵ���ֻ��һ����ĸ��
 *  ���� 1 <= i <= k ʱ��ÿ�� si ���� wordList �С�ע�⣬ beginWord ����Ҫ�� wordList �С�sk == endWord
 *  ������������ beginWord �� endWord ��һ���ֵ� wordList ������ �� beginWord �� endWord �� ���ת������ �е� ������Ŀ �����������������ת�����У����� 0 ��
 * �����/���˼·������һ������ͼ��Ȼ��ʹ�ù����������
 * ���룺�е�
 */
public class Day08_ladderLength {
    /**
     * ʱ�临�Ӷȣ�O��n^2��
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /* ����������� */
        if (beginWord == endWord || beginWord.equals(endWord)) return 0;
        if (wordList == null || wordList.size() == 0) return 0;
        /* ���й���������� */
        Set<String> container = new HashSet<>(); // ͼ��û�����ӣ���Ҫ����Ѱ���������ڽڵ㣩
        Queue<String> queue = new LinkedList<>(); // ���й����������
        int count = 1;
        for (int i = 0; i < wordList.size(); i++) {
            container.add(wordList.get(i));
        }
        container.add(beginWord);
        if (!container.contains(endWord)) return 0;
        queue.add(beginWord);
        container.remove(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String val = queue.poll();
                if (val.equals(endWord)) return count;
                List<String> needRemove = new LinkedList<>();
                /* ��ͼ�н�����Ϊ���ʹ������� val ���һ���ַ��� �ַ��� ���뵽������ */
                container.forEach(ele -> {
                    if (isApproximate(val, ele)) {
                        queue.add(ele);
                        needRemove.add(ele);
                    }
                });
                needRemove.forEach(ele -> container.remove(ele));
            }
            count++;
        }
        return 0;
    }

    /**
     * �ж� val1 �� val2 �Ƿ����һ���ַ�
     */
    private boolean isApproximate(String val1, String val2) {
        if (val1 == val2 || val1.equals(val2)) return false;
        if (val1.length() != val2.length()) return false;
        int diff = 0;
        for (int i = 0; i < val1.length(); i++) {
            if (val1.charAt(i) != val2.charAt(i)) {
                diff++;
                if (diff == 2) return false;
            }
        }
        return true;
    }
}