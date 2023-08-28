package month08;

/**
 * 时间：2023/8/28
 * 问题描述：
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 切入点/解决思路：使用后续遍历的方式
 * 感想：简单偏上
 */
public class Day28_getMinimumDifference {
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

    private int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        /* 特殊情况处理 */
        if (root == null) return -1;
        helper(root);
        return res;
    }

    /**
     * 后序遍历，返回当前二叉树最大值和最小值
     * @param root
     * @return
     */
    private int[] helper(TreeNode root) {
        int min = root.val; // 当前子树的最小值
        int max = root.val; // 当前子树的最大值
        if (root.left != null) {
            int[] left = helper(root.left);
            min = left[0];
            res = Math.min(root.val - left[1], res);
        }
        if (root.right != null) {
            int[] right = helper(root.right);
            max = right[1];
            res = Math.min(right[0] - root.val, res);
        }
        return new int[]{min, max};
    }

    /**
     * 使用中序遍历
     */
    private int res2 = Integer.MAX_VALUE;
    private int pre = -1; // 中序遍历中当前节点上一个节点的值

    public int getMinimumDifference2(TreeNode root) {
        /* 特殊情况处理 */
        if (root == null) return -1;
        helper2(root);
        return res2;
    }

    private void helper2(TreeNode node) {
        if (node.left != null) helper2(node.left);
        /* 计算当前节点额的值与中序遍历中上一个节点的差值，并尝试更新最小差值 */
        if (pre == -1) pre = node.val;
        else {
            res2 = Math.min(node.val - pre, res2);
            pre = node.val;
        }
        if (node.right != null) helper2(node.right);
    }

}