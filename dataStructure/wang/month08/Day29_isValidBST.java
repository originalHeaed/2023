package month08;

/**
 * 时间：2023/8/29
 * 问题描述：
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 切入点/解决思路：使用二叉树的中序遍历
 * 感想：中等
 */
public class Day29_isValidBST {
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

    private Integer pre = null;

    public boolean isValidBST(TreeNode root) {
        boolean valid = true;
        /* 进入左子树 */
        if (root.left != null) valid = valid && isValidBST(root.left);
        /* 判断当前节点与上一个节点的大小关系 */
        if (pre == null) pre = root.val;
        else if (pre >= root.val) valid = false;
        pre = root.val;
        /* 进入右子树 */
        if (root.right != null) valid = valid && isValidBST(root.right);
        return valid;
    }
}