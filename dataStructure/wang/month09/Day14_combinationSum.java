package month09;

import java.util.*;

/**
 * 时间：2023/9/14
 * 问题描述：
 *  给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *  candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *  对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * 切入点/解决思路：使用递归思想
 * 感想：中等
 */
public class Day14_combinationSum {
    /**
     * 保存结果集
     */
    private List<List<Integer>> res = new LinkedList<>();

    /**
     * 时间复杂度：O（n!）
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(candidates, new Stack<>(), 0, target);
        return res;
    }

    private void helper(int[] candidates, Stack<Integer> stack, int idx, int sum) {
        /* 递归结束条件 */
        if (sum == 0) {
            res.add(new LinkedList<>(stack));
            return;
        }
        if (idx >= candidates.length || sum < candidates[idx]) return;
        /* 递归体 */
        /* 跳过当前数字 */
        helper(candidates, stack, idx + 1, sum);
        /* 选择当前数字 */
        stack.push(candidates[idx]);
        helper(candidates, stack, idx, sum - candidates[idx]);
        stack.pop();
    }

    public static void main(String[] args) {
        Day14_combinationSum sum = new Day14_combinationSum();
        sum.combinationSum(new int[]{7, 2,3,6}, 7);
    }

}