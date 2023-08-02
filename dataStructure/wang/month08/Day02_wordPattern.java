package month08;

import java.util.HashMap;
import java.util.Map;

/**
 * ʱ�䣺2023/8/2
 * ����������
 *  ����һ�ֹ��� pattern ��һ���ַ��� s ���ж� s �Ƿ���ѭ��ͬ�Ĺ��ɡ�
 *  ����� ��ѭ ָ��ȫƥ�䣬���磬 pattern ���ÿ����ĸ���ַ��� s �е�ÿ���ǿյ���֮�������˫�����ӵĶ�Ӧ���ɡ�
 * �����/���˼·��ӳ�䣬�������һ�Զ����һ���ʾ����ѭ�ù���
 * ���룺��ƫ��
 */
public class Day02_wordPattern {
    /**
     * ʱ�临�Ӷȣ�O��n + m�����ռ临�Ӷȣ�O��n + m��
     */
    public boolean wordPattern(String pattern, String s) {
        /* ����������� */
        if (pattern == null || s == null || s.length() == 0 || pattern.length() == 0) return false;
        /* ʹ��ӳ���� */
        String[] map1 = new String[26]; // �����ַ������ʵ�ӳ���ϵ
        Map<String, Integer> map2 = new HashMap<>(); // �������ʵ��ַ���ӳ���ϵ
        String[] words = s.split(" ", 0); // s �е����е���
        if (words.length != pattern.length()) return false;
        /* pattern ÿ��һ����ĸ��s ����Ҫ��һ�����ʣ������ pattern �д���һ����ĸ��Ӧ������ʾͱ�ʾ�޷�ƥ�� */
        for (int i = 0; i < words.length; i++) {
            int index = pattern.charAt(i) - 'a';
            String word = words[i];
            /* ����һ�Զ����һ����� */
            if ((map1[index] != null && !map1[index].equals(word)) || (map2.containsKey(word) && map2.get(word) != index)) return false;
            map1[index] = word;
            map2.put(word, index);
        }
        return true;
    }
}