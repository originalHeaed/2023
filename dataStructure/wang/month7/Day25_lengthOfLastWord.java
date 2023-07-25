package month7;

/**
 * 时间：2023/7/25
 * 问题描述：
 * 切入点/解决思路：
 * 感想：
 */
public class Day25_lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        /* 特殊情况处理 */
        if (s == null || s.length() == 0) return 0;
        /* 开始计算 */
        int index = s.length() - 1;
        int total = 0;
        while (index >= 0 && s.charAt(index) == ' ') index--; // 去掉末尾空格
        while (index >= 0 && s.charAt(index--) != ' ') total++;
        return total;
    }
}