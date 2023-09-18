package month09;

/**
 * 时间：2023/9/18
 * 问题描述：
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 切入点/解决思路：使用分治算法
 * 感想：简单偏上
 */
public class Day18_sortedArrayToBST {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        /* 递归结束条件 */
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);
        /* 递归体 */
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = helper(nums, left, mid - 1);
        treeNode.right = helper(nums, mid + 1, right);
        return treeNode;
    }
}