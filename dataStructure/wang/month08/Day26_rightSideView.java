package month08;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 时间：2023/8/26
 * 问题描述：
 *  给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 切入点/解决思路：使用层序遍历即可
 * 感想：中等偏下
 */
public class Day26_rightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        /* 特殊情况处理 */
        if (root == null) return res;
        /* 用于辅助进行层序遍历 */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tem = queue.poll();
                if (tem.left != null) queue.add(tem.left);
                if (tem.right != null) queue.add(tem.right);
                if (i == (size - 1)) res.add(tem.val);
            }
        }
        return res;
    }
}
