package month08;

import java.util.Stack;

/**
 * 时间：2023/8/25
 * 问题描述：
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 *  BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 *  boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 *  int next()将指针向右移动，然后返回指针处的数字。
 * 切入点/解决思路：使用栈来模拟二叉树的中序搜索
 * 感想：中等
 */
public class Day25_BSTIterator {
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
     * 使用栈来实现二叉树的中序搜索
     */
    Stack<TreeNode> stack;

    public void BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * 每个元素只会入栈一次和出栈一次，因此平均下来每次调用 next 的时间复杂度为 O（1）
     * @return
     */
    public int next() {
        TreeNode node = stack.pop(); // 弹出一个节点，表示该节点的所有左子树全部遍历完毕
        int res = node.val;
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return res;
    }

    /**
     * 时间复杂度：O（1）
     * @return
     */
    public boolean hasNext() {
        return stack.isEmpty();
    }
}