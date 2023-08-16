package month08;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ʱ�䣺2023/8/16
 * ����������
 * ����������ĸ���� root �����㽫��չ��Ϊһ��������
 * չ����ĵ�����Ӧ��ͬ��ʹ�� TreeNode ������ right ��ָ��ָ����������һ����㣬������ָ��ʼ��Ϊ null ��
 * չ����ĵ�����Ӧ��������� ������� ˳����ͬ��
 * �����/���˼·��ʹ���������������������
 * ���룺�е�
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
        /* ���ڵ㰴���������������� */
        helper(root, queue);
        /* ���ڵ���д��� */
        TreeNode guard = new TreeNode();
        TreeNode tem = guard;
        while (!queue.isEmpty()) {
            tem.right = queue.peek();
            tem = queue.poll();
        }
    }

    public void helper(TreeNode node, Queue<TreeNode> queue) {
        /* �ݹ�������� */
        if (node == null) return;
        /* ��ʱ��������ָ�� */
        TreeNode left = node.left;
        TreeNode right = node.right;
        /* ���ýڵ���뵽���������� */
        node.left = null;
        node.right = null;
        queue.add(node);
        /* ���еݹ� */
        helper(left, queue);
        helper(right, queue);
    }

    public void flatten2(TreeNode root) {
        helper2(root, new TreeNode());
    }

    public TreeNode helper2(TreeNode node, TreeNode head) {
        /* �ݹ�������� */
        if (node == null) return head;
        /* ��ʱ��������ָ�� */
        TreeNode left = node.left;
        TreeNode right = node.right;
        /* ���ýڵ���뵽���������� */
        node.left = null;
        node.right = null;
        head.right = node;
        /* ���еݹ飬�����������ڵ���뵽������ */
        return helper2(right, helper2(left, node));
    }

}