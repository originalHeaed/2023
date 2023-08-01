package month08;

import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

/**
 * ʱ�䣺2023/8/1
 * ����������
 *  ����һ���ַ��� s ��һ���ַ��� t ������ s �к��� t �����ַ�����С�Ӵ������ s �в����ں��� t �����ַ����Ӵ����򷵻ؿ��ַ��� "" ��
 *  ע�⣺
 *  ���� t ���ظ��ַ�������Ѱ�ҵ����ַ����и��ַ��������벻���� t �и��ַ�������
 *  ��� s �д����������Ӵ������Ǳ�֤����Ψһ�Ĵ𰸡�
 * �����/���˼·��ʹ�û�������
 * ���룺�е�ƫ��
 */
public class Day01_minWindow {
    /**
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��1��
     */
    public String minWindow(String s, String t) {
        int l = 0;
        int r = s.length() - 1;
        /* ��������ж� */
        if (s == null || t == null || s.length() < t.length()) return "";
        /* ʹ��˫ָ�� */
        Map<Character, Integer> map = new HashMap<>(); // ��¼������ȱ�ٵ��ַ��Լ����ִ���
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        /* ÿ��������һ��ͬʱ����������������ָ���Ƿ��������Լ��������� */
        while (right < chars.length) {
            if (map.containsKey(chars[right])) map.put(chars[right], map.get(chars[right]) - 1);
            while (left <= right && (!map.containsKey(chars[left]) || map.get(chars[left]) < 0)) {
                if (map.containsKey(chars[left])) map.put(chars[left], map.get(chars[left]) + 1);
                left++;
            }
            if (mapIsEmpty(map) && (right - left) < (r - l)) {
                r = right;
                l = left;
            }
            right++;
        }
        return mapIsEmpty(map) ? s.substring(l, r + 1) : "";
    }

    /**
     * �жϵ�ǰ�����Ƿ����������Ч�ַ�
     * @param map
     * @return
     */
    private boolean mapIsEmpty(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) return false;
        }
        return true;
    }
}