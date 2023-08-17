package month08;

/**
 * 时间：2023/8/17
 * 问题描述：
 *  给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 *  每条从根节点到叶节点的路径都代表一个数字：
 *  例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 *  计算从根节点到叶节点生成的 所有数字之和 。
 *  叶节点 是指没有子节点的节点。
 * 切入点/解决思路：使用深度优先搜索
 * 感想：简单偏下
 */
public class Day17_sumNumbers {
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

    /**
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (root.left != null) root.left.val = root.val * 10 + root.left.val;
        if (root.right != null) root.right.val = root.val * 10 + root.right.val;
        return sumNumbers(root.left) + sumNumbers(root.right);
    }
}