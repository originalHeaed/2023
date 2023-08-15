package month08;

/**
 * 时间：2023/8/15
 * 问题描述：
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 切入点/解决思路：递归
 * 感想：中等偏上
 */
public class Day15_buildTree {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return findNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode findNode(int[] pre, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preRight < preLeft) return null;
        TreeNode treeNode = new TreeNode(pre[preLeft]);
        if (preLeft != preRight) {
            int preMid = preLeft;
            int inMid = inLeft;
            while (inorder[inMid] != pre[preLeft]) {
                preMid++;
                inMid++;
            }
            treeNode.left = findNode(pre, preLeft + 1, preMid, inorder, inLeft, inMid - 1);
            treeNode.right = findNode(pre, preMid + 1, preRight, inorder, inMid + 1, inRight);
        }
        return treeNode;
    }

}