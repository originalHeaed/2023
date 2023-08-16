package month08;

/**
 * ʱ�䣺2023/8/16
 * ����������
 * ���������������� inorder �� postorder ������ inorder �Ƕ����������������
 * postorder ��ͬһ�����ĺ�����������㹹�첢������� ������ ��
 * �����/���˼·��ʹ�õݹ��������ݺ�������ҵ���ǰ�������ĸ��ڵ㣬Ȼ������������ȷ�ظø��ڵ����������Ľڵ�����Ȼ���ں�������ҵ���һ�������ķ�Χ���ݹ���У�
 * ���룺�е�ƫ��
 */
public class Day16_buildTree {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inLeft, int inRight, int[] post, int postLeft, int postRight) {
        /* �ݹ���ֹ���� */
        if (inLeft > inRight) return null;
        TreeNode treeNode = new TreeNode(post[postRight]);
        if (inLeft == inRight) return treeNode;
        /* ���еݹ� */
        int midPost = postRight;
        int midInorder = inRight;
        /* ������������ҵ����ڵ��λ�ã���ȷ�Ϻ�����������Щ��Χ���ڸø��ڵ�������������Щ��Χ���ڸ��ڵ�������� */
        while (inorder[midInorder] != post[postRight]) {
            midInorder--;
            midPost--;
        }
        treeNode.left = helper(inorder, inLeft, midInorder - 1, post, postLeft, midPost - 1);
        treeNode.right = helper(inorder, midInorder + 1, inRight, post, midPost, postRight - 1);
        return treeNode;
    }

}