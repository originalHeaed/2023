package month7;

/**
 * 时间：2023/7/26
 * 问题描述：
 *  编写一个函数来查找字符串数组中的最长公共前缀。
 *  如果不存在公共前缀，返回空字符串 ""。
 * 切入点/解决思路：采用纵向思路
 * 感想：简单
 */
public class Day26_longestCommonPrefix {

    /**
     * 时间复杂度：O(n * m)，空间复杂度：O（n），m 是最长前缀的长度
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        /* 特殊情况考虑 */
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        /* 开始找最长公共前缀 */
        int index = 0;
        while (isEqual(strs, index)) index++;
        return strs[0].substring(0, index);
    }

    private boolean isEqual(String[] arr, int index) {
        if (index >= arr[0].length()) return false;
        for (int i = 1; i < arr.length; i++) {
            if (index >= arr[i].length() || arr[i].charAt(index) != arr[0].charAt(index)) return false;
        }
        return true;
    }
}