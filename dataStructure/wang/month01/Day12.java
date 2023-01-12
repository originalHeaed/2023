package month01;

public class Day12 {
    //=============== 在二叉树中分配硬币 =======================

    /**
     * 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
     * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
     * 返回使每个结点上只有一枚硬币所需的移动次数。
     */
    class TreeNode {
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

    /**
     * 以每个根节点作为调配点，损有余而不足
     * 时间复杂度：O（n）
     */
    private int res = 0;
    public int distributeCoins(TreeNode root) {
        recursion(root);
        return res;
    }

    private int recursion(TreeNode root) {
        /* 递归结束条件 */
        if (root == null) return 0;
        /* 计算左右少的或多的硬币数，然后进行累加，将少的或多的上报给上级 */
        int left = recursion(root.left);
        int right = recursion(root.right);
        res += Math.abs(left) + Math.abs(right);
        return left + right + root.val - 1;
    }
}
