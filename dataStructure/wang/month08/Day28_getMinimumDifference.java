package month08;

/**
 * ʱ�䣺2023/8/28
 * ����������
 * ����һ�������������ĸ��ڵ� root ������ ������������ͬ�ڵ�ֵ֮�����С��ֵ ��
 * ��ֵ��һ������������ֵ������ֵ֮��ľ���ֵ��
 * �����/���˼·��ʹ�ú��������ķ�ʽ
 * ���룺��ƫ��
 */
public class Day28_getMinimumDifference {
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

    private int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        /* ����������� */
        if (root == null) return -1;
        helper(root);
        return res;
    }

    /**
     * ������������ص�ǰ���������ֵ����Сֵ
     * @param root
     * @return
     */
    private int[] helper(TreeNode root) {
        int min = root.val; // ��ǰ��������Сֵ
        int max = root.val; // ��ǰ���������ֵ
        if (root.left != null) {
            int[] left = helper(root.left);
            min = left[0];
            res = Math.min(root.val - left[1], res);
        }
        if (root.right != null) {
            int[] right = helper(root.right);
            max = right[1];
            res = Math.min(right[0] - root.val, res);
        }
        return new int[]{min, max};
    }

    /**
     * ʹ���������
     */
    private int res2 = Integer.MAX_VALUE;
    private int pre = -1; // ��������е�ǰ�ڵ���һ���ڵ��ֵ

    public int getMinimumDifference2(TreeNode root) {
        /* ����������� */
        if (root == null) return -1;
        helper2(root);
        return res2;
    }

    private void helper2(TreeNode node) {
        if (node.left != null) helper2(node.left);
        /* ���㵱ǰ�ڵ���ֵ�������������һ���ڵ�Ĳ�ֵ�������Ը�����С��ֵ */
        if (pre == -1) pre = node.val;
        else {
            res2 = Math.min(node.val - pre, res2);
            pre = node.val;
        }
        if (node.right != null) helper2(node.right);
    }

}