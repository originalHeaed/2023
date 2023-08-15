package month08;

/**
 * ʱ�䣺2023/8/15
 * ����������
 * ���������������� preorder �� inorder ������ preorder �Ƕ����������������
 * inorder ��ͬһ����������������빹�����������������ڵ㡣
 * �����/���˼·���ݹ�
 * ���룺�е�ƫ��
 */
public class Day15_buildTree {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return findNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode findNode(int[] pre, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preRight < preLeft) return null;
        TreeNode treeNode = new TreeNode(pre[preLeft]);
        if (preLeft != preRight) {
            int preMid = preLeft;
            int inMid = inLeft;
            while (inorder[inMid] != pre[preLeft]) {
                preMid++;
                inMid++;
            }
            treeNode.left = findNode(pre, preLeft + 1, preMid, inorder, inLeft, inMid - 1);
            treeNode.right = findNode(pre, preMid + 1, preRight, inorder, inMid + 1, inRight);
        }
        return treeNode;
    }

}