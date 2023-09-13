package month09;

import java.util.*;
import java.util.stream.Stream;

/**
 * 时间：2023/9/13
 * 问题描述：
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 切入点/解决思路：使用深度优先搜索
 * 感想：中等
 */
public class Day13_letterCombinations {
    /**
     * 结果集合
     */
    private List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new LinkedList<>();
        /* 特殊情况处理 */
        if (digits == null || digits.length() == 0) return res;
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        Set<Character> next = new HashSet<>(); // 在深度优先搜索过程中记录已经访问的字符
        getCombination(map, digits, 0, "");
        return res;
    }

    /**
     * 深度优先搜索找到所有的组合
     */
    private void getCombination(Map<Character, char[]> map, String digit, int index, String sb) {
        /* 递归结束条件 */
        if (index == digit.length()) {
            res.add(sb);
            return;
        }
        /* 进行递归 */
        char ele = digit.charAt(index);
        for (char c : map.get(ele)) {
            getCombination(map, digit, index + 1, sb + c);
        }
    }

}