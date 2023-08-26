package month08;

/**
 * ʱ�䣺2023/8/26
 * ����������
 * �������е� ·�� ������Ϊһ���ڵ����У�������ÿ�����ڽڵ�֮�䶼����һ���ߡ�ͬһ���ڵ���һ��·�������� �������һ�� ����·�� ���ٰ���һ�� �ڵ㣬�Ҳ�һ���������ڵ㡣
 * ·���� ��·���и��ڵ�ֵ���ܺ͡�
 * ����һ���������ĸ��ڵ� root �������� ���·���� ��
 * �����/���˼·�����ú�������ķ�ʽ
 * ���룺����
 */
public class Day26_maxPathSum {
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


    int res;

    public int maxPathSum(TreeNode root) {
        /* ����������� */
        if (root == null) return -1;
        res = root.val;
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        int leftMax = 0;
        int rightMax = 0;
        /* �����������ֵ */
        if (node.left != null) leftMax = helper(node.left);
        if (node.right != null) rightMax = helper(node.right);
        /* ���¿��ܵ����ֵ */
        int temMax = node.val;
        temMax = Math.max(leftMax + node.val, temMax);
        temMax = Math.max(rightMax + node.val, temMax);
        temMax = Math.max(leftMax + rightMax + node.val, temMax);
        res = Math.max(temMax, res);
        /* ��ȡ�Ե�ǰ�ڵ�Ϊ�˽ڵ�����ֵ */
        temMax = node.val;
        temMax = Math.max(leftMax + node.val, temMax);
        temMax = Math.max(rightMax + node.val, temMax);
        return temMax;
    }

}