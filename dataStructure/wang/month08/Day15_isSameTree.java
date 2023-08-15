package month08;

/**
 * 时间：2023/8/15
 * 问题描述：
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 切入点/解决思路：使用深度优先搜索，递归判断
 * 感想：简单
 */
public class Day15_isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null && q == null;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

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

}