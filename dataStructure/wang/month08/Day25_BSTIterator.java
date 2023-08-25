package month08;

import java.util.Stack;

/**
 * ʱ�䣺2023/8/25
 * ����������
 * ʵ��һ��������������������BSTIterator ����ʾһ�����������������������BST���ĵ�������
 *  BSTIterator(TreeNode root) ��ʼ�� BSTIterator ���һ������BST �ĸ��ڵ� root ����Ϊ���캯����һ���ָ�����ָ��Ӧ��ʼ��Ϊһ���������� BST �е����֣��Ҹ�����С�� BST �е��κ�Ԫ�ء�
 *  boolean hasNext() �����ָ���Ҳ�����������֣��򷵻� true �����򷵻� false ��
 *  int next()��ָ�������ƶ���Ȼ�󷵻�ָ�봦�����֡�
 * �����/���˼·��ʹ��ջ��ģ�����������������
 * ���룺�е�
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
     * ʹ��ջ��ʵ�ֶ���������������
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
     * ÿ��Ԫ��ֻ����ջһ�κͳ�ջһ�Σ����ƽ������ÿ�ε��� next ��ʱ�临�Ӷ�Ϊ O��1��
     * @return
     */
    public int next() {
        TreeNode node = stack.pop(); // ����һ���ڵ㣬��ʾ�ýڵ������������ȫ���������
        int res = node.val;
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return res;
    }

    /**
     * ʱ�临�Ӷȣ�O��1��
     * @return
     */
    public boolean hasNext() {
        return stack.isEmpty();
    }
}