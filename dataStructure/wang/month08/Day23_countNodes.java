package month08;

/**
 * 时间：2023/8/23
 * 问题描述：
 * 切入点/解决思路：
 * 感想：
 */
public class Day23_countNodes {
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

    int res = 0;

    public int countNodes(TreeNode root) {
        helper(root);
        return res;
    }

    private void helper(TreeNode node) {
        if (node == null) return;
        res++;
        helper(node.left);
        helper(node.right);
    }
}