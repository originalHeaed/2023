package month08;

/**
 * ʱ�䣺2023/8/29
 * ����������
 * ����һ���������ĸ��ڵ� root ���ж����Ƿ���һ����Ч�Ķ�����������
 * ��Ч �����������������£�
 * �ڵ��������ֻ���� С�� ��ǰ�ڵ������
 * �ڵ��������ֻ���� ���� ��ǰ�ڵ������
 * �������������������������Ҳ�Ƕ�����������
 * �����/���˼·��ʹ�ö��������������
 * ���룺�е�
 */
public class Day29_isValidBST {
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

    private Integer pre = null;

    public boolean isValidBST(TreeNode root) {
        boolean valid = true;
        /* ���������� */
        if (root.left != null) valid = valid && isValidBST(root.left);
        /* �жϵ�ǰ�ڵ�����һ���ڵ�Ĵ�С��ϵ */
        if (pre == null) pre = root.val;
        else if (pre >= root.val) valid = false;
        pre = root.val;
        /* ���������� */
        if (root.right != null) valid = valid && isValidBST(root.right);
        return valid;
    }
}