package month08;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间：2023/8/2
 * 问题描述：
 *  给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *  如果可以，返回 true ；否则返回 false 。
 *  magazine 中的每个字符只能在 ransomNote 中使用一次。
 * 切入点/解决思路：使用 map 直接解决
 * 感想：简单
 */
public class Day02_canConstruct {
    /**
     * 时间复杂度：O（n + m），空间复杂度：O（1）
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        /* 特殊情况处理 */
        if (ransomNote == null || magazine == null || ransomNote.length() > magazine.length()) return false;
        /* 使用 map 解决 */
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }
        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) {
                if (map.get(magazine.charAt(i)) == 1) {
                    map.remove(magazine.charAt(i));
                } else {
                    map.put(magazine.charAt(i), map.get(magazine.charAt(i)) - 1);
                }
            }
        }
        return map.isEmpty();
    }

}