package month08;

/**
 * ʱ�䣺2023/8/17
 * ����������
 *  ����һ���������ĸ��ڵ� root ������ÿ���ڵ㶼�����һ�� 0 �� 9 ֮������֡�
 *  ÿ���Ӹ��ڵ㵽Ҷ�ڵ��·��������һ�����֣�
 *  ���磬�Ӹ��ڵ㵽Ҷ�ڵ��·�� 1 -> 2 -> 3 ��ʾ���� 123 ��
 *  ����Ӹ��ڵ㵽Ҷ�ڵ����ɵ� ��������֮�� ��
 *  Ҷ�ڵ� ��ָû���ӽڵ�Ľڵ㡣
 * �����/���˼·��ʹ�������������
 * ���룺��ƫ��
 */
public class Day17_sumNumbers {
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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (root.left != null) root.left.val = root.val * 10 + root.left.val;
        if (root.right != null) root.right.val = root.val * 10 + root.right.val;
        return sumNumbers(root.left) + sumNumbers(root.right);
    }
}