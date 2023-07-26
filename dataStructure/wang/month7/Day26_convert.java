package month7;

import java.util.Arrays;

/**
 * 时间：2023/7/26
 * 问题描述：
 *  将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *  将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 切入点/解决思路：直接采用取模算法
 * 感想：简单
 */
public class Day26_convert {
    /**
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    public String convert(String s, int numRows) {
        /* 特殊处理 */
        if (s == null || s.length() == 0 || numRows <= 1) return s;
        /* 获取每行的处理结果 */
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) builders[i] = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++, index++) {
                builders[i].append(s.charAt(index));
            }
            for (int i = numRows - 2; i > 0 && index < s.length(); i--, index++) {
                builders[i].append(s.charAt(index));
            }
        }
        /* 拼接最终结果 */
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(builders[i].toString());
        }
        return res.toString();
    }
}