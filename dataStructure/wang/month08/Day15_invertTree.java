package month08;

/**
 * 时间：2023/8/15
 * 问题描述：给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 切入点/解决思路：深度优先搜索，递归
 * 感想：简单
 */
public class Day15_invertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }

}