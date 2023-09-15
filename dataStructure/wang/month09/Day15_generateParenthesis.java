package month09;

import java.util.LinkedList;
import java.util.List;

/**
 * 时间：2023/9/15
 * 问题描述：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 切入点/解决思路：使用回溯的方式
 * 感想：中等
 */
public class Day15_generateParenthesis {
    /**
     * 保存结果
     */
    private List<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        helper(new LinkedList<>(), n, 0);
        return res;
    }

    /**
     * left 剩余可以使用的左括号数量
     * right 剩余需要填补的右括号数量
     */
    private void helper(List<Character> list, int left, int right) {
        /* 递归结束条件 */
        if (left == 0 && right == 0) {
            StringBuilder sb = new StringBuilder();
            list.stream().forEach(ele -> sb.append(ele));
            res.add(sb.toString());
            return;
        }
        /* 递归体 */
        if (left > 0) {
            list.add('(');
            helper(list, left - 1, right + 1);
            list.remove(list.size() - 1);
        }
        if (right > 0) {
            list.add(')');
            helper(list, left, right - 1);
            list.remove(list.size() - 1);
        }
    }
}