package month7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 时间：2023/7/31
 * 问题描述：
 *  给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 *   s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 *  例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 *  返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 * 切入点/解决思路：使用暴力法 + 双指针
 * 感想：
 */
public class Day31_findSubstring {
    /**
     * 使用暴力法，时间复杂度：O（n * m）,n - 字符串的长度，m 是数组的长度
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        /* 特殊情况处理 */
        if (s == null || s.equals("") || words == null || words.length == 0 || words[0].length() == 0) return res;
        /* 使用暴力法 */
        int baseLen = words[0].length();
        int totalLen = baseLen * words.length;
        String[] arr = new String[s.length() - baseLen + 1]; // 以 s 中每个字母尾首，长度为 baseLen 的字符串数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.substring(i, i + baseLen);
        }
        /* 记录 words 中的字符串 */
        Map<String, Integer> map = new HashMap<>();
        for (int k = 0; k < words.length; k++) {
            map.put(words[k], map.getOrDefault(words[k], 0) + 1);
        }
        /* 判断第 i 个字符开始组成的字符串是否为串联子串 */
        for (int i = 0; i < arr.length; i++) {
            if ((i + totalLen - 1) >= s.length()) break;
            /* 判断 [i, i + totalLen - 1] 组成的子串是否为串联子串 */
            Map<String, Integer> tem = new HashMap<>();
            boolean isSub = true;
            for (int j = 0; j < words.length; j++) {
                Integer targetTime = map.get(arr[i + j * baseLen]);
                tem.put(arr[i + j * baseLen], tem.getOrDefault(arr[i + j * baseLen], 0) + 1);
                Integer targetTem = tem.get(arr[i + j * baseLen]);
                if (targetTime == null || targetTem > targetTime) {
                    isSub = false;
                    break; // 不能以该字符为首
                }
            }
            /* 如果 map 中的字符串全部被匹配完，则表示 [i, i + totalLen - 1] 可以作为串联子串 */
            if (isSub) res.add(i);
        }
        return res;
    }

    /**
     * 时间复杂度：O（n * m），n - 单词的长度，m 字符串长度
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        /* 特殊情况处理 */
        if (s == null || s.equals("") || words == null || words.length == 0 || words[0].length() == 0) return res;
        /* 使用暴力法 */
        int baseLen = words[0].length();
        int totalLen = baseLen * words.length;
        /* 以 s 中每个字母尾首，长度为 baseLen 的字符串数组 */
        String[] arr = new String[s.length() - baseLen + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.substring(i, i + baseLen);
        }
        /* 记录 words 中的字符串 */
        Map<String, Integer> map = new HashMap<>();
        for (int k = 0; k < words.length; k++) {
            map.put(words[k], map.getOrDefault(words[k], 0) + 1);
        }
        /* 使用滑动窗口方法判断是否为串联子串 */
        for (int i = 0; i < baseLen; i++) {
            if ((i + totalLen - 1) >= s.length()) break;
            int left = i;
            int right = i;
            Map<String, Integer> tem = new HashMap<>();
            while (right < arr.length) {
                Integer time1 = map.get(arr[right]);
                tem.put(arr[right], tem.getOrDefault(arr[right], 0) + 1);
                Integer time2 = tem.get(arr[right]);
                /* 当前 right 指向的单词不在 words 中或将该单词加入串联子串后导致某个单词多了，因此左指针开始收缩，直到略过一个当前单词为止 */
                if (time1 == null || time2 > time1) {
                    while (left <= right) {
                        tem.put(arr[left], tem.get(arr[left]) - 1);
                        Integer count = tem.get(arr[left]);
                        if (count == 0) tem.remove(arr[left]);
                        if (arr[left].equals(arr[right])) {
                            left += baseLen;
                            break;
                        }
                        left += baseLen;
                    }
                }
                /* 如果当前滑动窗口的长度等于 words 所有单词总长度，则表示这是一个串联子串 */
                if ((right + baseLen - left) == totalLen) res.add(left);
                right += baseLen;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String  i = "12";
        System.out.println(i.substring(0, 2));
    }

}