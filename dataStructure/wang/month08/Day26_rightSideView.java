package month08;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ʱ�䣺2023/8/26
 * ����������
 *  ����һ���������� ���ڵ� root�������Լ�վ�������Ҳ࣬���մӶ������ײ���˳�򣬷��ش��Ҳ����ܿ����Ľڵ�ֵ��
 * �����/���˼·��ʹ�ò����������
 * ���룺�е�ƫ��
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
        /* ����������� */
        if (root == null) return res;
        /* ���ڸ������в������ */
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
