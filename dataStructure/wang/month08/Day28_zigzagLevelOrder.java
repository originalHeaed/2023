package month08;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 时间：2023/8/28
 * 问题描述：
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 切入点/解决思路：使用双栈来进行锯齿形层序遍历
 * 感想：中等偏下
 */
public class Day28_zigzagLevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        /* 特殊情况处理 */
        if (root == null) return res;
        /* 使用双栈进行 */
        Stack<TreeNode> leftToRight = new Stack<>(); // 保存从左到右顺序的节点
        Stack<TreeNode> rightToLeft = new Stack<>(); // 保存从右到左顺序的节点
        leftToRight.push(root);
        while (!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            if (!leftToRight.isEmpty()) {
                /* 本次层序遍历是从左到右，需要将下一层节点从右到左存放 */
                while (!leftToRight.isEmpty()) {
                    TreeNode pop = leftToRight.pop();
                    level.add(pop.val);
                    if (pop.left != null) rightToLeft.push(pop.left);
                    if (pop.right != null) rightToLeft.push(pop.right);
                }
            } else {
                /* 本次层序遍历是从右到左，需要将下一层节点从左到右存放 */
                while (!rightToLeft.isEmpty()) {
                    TreeNode pop = rightToLeft.pop();
                    level.add(pop.val);
                    if (pop.right != null) leftToRight.push(pop.right);
                    if (pop.left != null) leftToRight.push(pop.left);
                }
            }
            res.add(level);
        }
        return res;
    }
}