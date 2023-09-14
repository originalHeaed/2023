package month09;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 时间：2023/9/14
 * 问题描述：
 *  给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 切入点/解决思路：使用深度优先搜索
 * 感想：中等
 */
public class Day14_permute {
    private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        /* 特殊情况处理 */
        if (nums == null || nums.length == 0) return res;
        /* 递归处理 */
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        helper(set, new LinkedList<>());
        return res;
    }

    private void helper(Set<Integer> container, List<Integer> list) {
        /* 递归结束条件 */
        if (container.isEmpty()) res.add(new LinkedList<>(list));
        /* 进行递归 */
        Set<Integer> copy = new HashSet<>(container);
        copy.stream().forEach(ele -> {
            container.remove(ele);
            list.add(ele);
            helper(container, list);
            container.add(ele);
            list.remove(ele);
        });
    }

}