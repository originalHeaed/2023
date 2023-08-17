package month08;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ʱ�䣺2023/8/17
 * ����������
 *  ����һ���ǿն������ĸ��ڵ� root , ���������ʽ����ÿһ��ڵ��ƽ��ֵ����ʵ�ʴ���� 10-5 ���ڵĴ𰸿��Ա����ܡ�
 * �����/���˼·���������
 * ���룺��
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
     * ʱ�临�Ӷȣ�O��n��
     * �ռ临�Ӷȣ�O��n��
     */
    public List<Double> averageOfLevels(TreeNode root) {
        /* ����������� */
        if (root == null) return new LinkedList<>();
        /* ʹ�ø������н��в������ */
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