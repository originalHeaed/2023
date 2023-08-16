package month08;

/**
 * 时间：2023/8/16
 * 问题描述：
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * 切入点/解决思路：使用递归解决（根据后序遍历找到当前二叉树的根节点，然后根据中序遍历确地该根节点左右子树的节点数，然后在后序遍历找到下一个子树的范围，递归进行）
 * 感想：中等偏上
 */
public class Day16_buildTree {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inLeft, int inRight, int[] post, int postLeft, int postRight) {
        /* 递归终止条件 */
        if (inLeft > inRight) return null;
        TreeNode treeNode = new TreeNode(post[postRight]);
        if (inLeft == inRight) return treeNode;
        /* 进行递归 */
        int midPost = postRight;
        int midInorder = inRight;
        /* 在中序遍历中找到根节点的位置，并确认后续遍历中哪些范围属于该根节点额度左子树，哪些范围属于根节点的右子树 */
        while (inorder[midInorder] != post[postRight]) {
            midInorder--;
            midPost--;
        }
        treeNode.left = helper(inorder, inLeft, midInorder - 1, post, postLeft, midPost - 1);
        treeNode.right = helper(inorder, midInorder + 1, inRight, post, midPost, postRight - 1);
        return treeNode;
    }

}