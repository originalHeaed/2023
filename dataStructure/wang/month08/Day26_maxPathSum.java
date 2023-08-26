package month08;

/**
 * 时间：2023/8/26
 * 问题描述：
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * 切入点/解决思路：采用后序遍历的方式
 * 感想：困难
 */
public class Day26_maxPathSum {
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


    int res;

    public int maxPathSum(TreeNode root) {
        /* 特殊情况考虑 */
        if (root == null) return -1;
        res = root.val;
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        int leftMax = 0;
        int rightMax = 0;
        /* 计算左右最大值 */
        if (node.left != null) leftMax = helper(node.left);
        if (node.right != null) rightMax = helper(node.right);
        /* 更新可能的最大值 */
        int temMax = node.val;
        temMax = Math.max(leftMax + node.val, temMax);
        temMax = Math.max(rightMax + node.val, temMax);
        temMax = Math.max(leftMax + rightMax + node.val, temMax);
        res = Math.max(temMax, res);
        /* 获取以当前节点为端节点的最大值 */
        temMax = node.val;
        temMax = Math.max(leftMax + node.val, temMax);
        temMax = Math.max(rightMax + node.val, temMax);
        return temMax;
    }

}