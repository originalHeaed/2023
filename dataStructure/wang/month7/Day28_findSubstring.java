package month7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 时间：2023/7/28
 * 问题描述：
 *  给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 *   s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 *  例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 *  返回所有串联字串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 * 切入点/解决思路：针对字符串 s 使用滑动窗口
 * 感想：大于中等，小于困难
 */
public class Day28_findSubstring {
    /**
     * 使用滑动窗口来查找子串
     * 时间复杂度：O（max(m,n)
     * 空间复杂度：O（n）
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        /* 特殊情况处理 */
        if (s == null || s.equals("") || words == null || words.length == 0) return res;
        /* 使用滑动窗口来查找所有子串 */
        int left = 0;
        int right = 0;
        int len = words[0].length(); // 单词的基本长度
        Map<String, Integer> map = new HashMap<>(); // 记录当前滑动窗口内还未匹配 words 中的字符串
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        while (right < s.length()) {
            right += len;
            if (right >= s.length()) break;
            String tem = s.substring(right - left, right); // 本次向右滑动容纳
            if (map.containsKey(tem)) {
                int time = map.get(tem) - 1;
                if (time == 0) map.remove(tem);
                else map.put(tem, time);
            }
        }
        return res;
    }
}