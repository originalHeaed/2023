package month08;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 时间：2023/8/16
 * 问题描述：
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 切入点/解决思路：使用先序遍历串联起来即可
 * 感想：中等
 */
public class Day16_flatten {
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


    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        /* 将节点按先序遍历加入队列中 */
        helper(root, queue);
        /* 将节点进行串联 */
        TreeNode guard = new TreeNode();
        TreeNode tem = guard;
        while (!queue.isEmpty()) {
            tem.right = queue.peek();
            tem = queue.poll();
        }
    }

    public void helper(TreeNode node, Queue<TreeNode> queue) {
        /* 递归结束条件 */
        if (node == null) return;
        /* 临时保留左右指针 */
        TreeNode left = node.left;
        TreeNode right = node.right;
        /* 将该节点加入到最终链表中 */
        node.left = null;
        node.right = null;
        queue.add(node);
        /* 进行递归 */
        helper(left, queue);
        helper(right, queue);
    }

    public void flatten2(TreeNode root) {
        helper2(root, new TreeNode());
    }

    public TreeNode helper2(TreeNode node, TreeNode head) {
        /* 递归结束条件 */
        if (node == null) return head;
        /* 临时保留左右指针 */
        TreeNode left = node.left;
        TreeNode right = node.right;
        /* 将该节点加入到最终链表中 */
        node.left = null;
        node.right = null;
        head.right = node;
        /* 进行递归，将左右子树节点加入到链表中 */
        return helper2(right, helper2(left, node));
    }

}