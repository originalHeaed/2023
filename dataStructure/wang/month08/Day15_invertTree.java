package month08;

/**
 * ʱ�䣺2023/8/15
 * ��������������һ�ö������ĸ��ڵ� root ����ת��ö�����������������ڵ㡣
 * �����/���˼·����������������ݹ�
 * ���룺��
 */
public class Day15_invertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }

}