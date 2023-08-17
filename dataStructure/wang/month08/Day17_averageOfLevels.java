package month08;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 时间：2023/8/17
 * 问题描述：
 *  给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 * 切入点/解决思路：层序遍历
 * 感想：简单
 */
public class Day17_averageOfLevels {
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
    public List<Double> averageOfLevels(TreeNode root) {
        /* 特殊情况处理 */
        if (root == null) return new LinkedList<>();
        /* 使用辅助队列进行层序遍历 */
        List<Double> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double val = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                val += poll.val;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            res.add(val / size );
        }
        return res;
    }
}