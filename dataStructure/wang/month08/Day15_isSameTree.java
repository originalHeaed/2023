package month08;

/**
 * ʱ�䣺2023/8/15
 * ����������
 * �������ö������ĸ��ڵ� p �� q ����дһ���������������������Ƿ���ͬ��
 * ����������ڽṹ����ͬ�����ҽڵ������ͬ��ֵ������Ϊ��������ͬ�ġ�
 * �����/���˼·��ʹ����������������ݹ��ж�
 * ���룺��
 */
public class Day15_isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null && q == null;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

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

}