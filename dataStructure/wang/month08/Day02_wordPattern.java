package month08;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间：2023/8/2
 * 问题描述：
 *  给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *  这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * 切入点/解决思路：映射，如果存在一对多或多对一则表示不遵循该规律
 * 感想：简单偏上
 */
public class Day02_wordPattern {
    /**
     * 时间复杂度：O（n + m），空间复杂度：O（n + m）
     */
    public boolean wordPattern(String pattern, String s) {
        /* 特殊情况考虑 */
        if (pattern == null || s == null || s.length() == 0 || pattern.length() == 0) return false;
        /* 使用映射解决 */
        String[] map1 = new String[26]; // 建立字符到单词的映射关系
        Map<String, Integer> map2 = new HashMap<>(); // 建立单词到字符的映射关系
        String[] words = s.split(" ", 0); // s 中的所有单词
        if (words.length != pattern.length()) return false;
        /* pattern 每过一个字母，s 就需要过一个单词，如果在 pattern 中存在一个字母对应多个单词就表示无法匹配 */
        for (int i = 0; i < words.length; i++) {
            int index = pattern.charAt(i) - 'a';
            String word = words[i];
            /* 存在一对多或多对一的情况 */
            if ((map1[index] != null && !map1[index].equals(word)) || (map2.containsKey(word) && map2.get(word) != index)) return false;
            map1[index] = word;
            map2.put(word, index);
        }
        return true;
    }
}