package month08;

import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

/**
 * 时间：2023/8/1
 * 问题描述：
 *  给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *  注意：
 *  对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 *  如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 切入点/解决思路：使用滑动窗口
 * 感想：中等偏上
 */
public class Day01_minWindow {
    /**
     * 时间复杂度：O（n），空间复杂度：O（1）
     */
    public String minWindow(String s, String t) {
        int l = 0;
        int r = s.length() - 1;
        /* 特殊情况判断 */
        if (s == null || t == null || s.length() < t.length()) return "";
        /* 使用双指针 */
        Map<Character, Integer> map = new HashMap<>(); // 记录窗口内缺少的字符以及出现次数
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        /* 每次向右扩一格，同时根据条件来决定左指针是否收缩，以及收缩多少 */
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
     * 判断当前窗口是否包含所有有效字符
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