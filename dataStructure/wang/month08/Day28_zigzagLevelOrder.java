package month08;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * ʱ�䣺2023/8/28
 * ����������
 * ����������ĸ��ڵ� root ��������ڵ�ֵ�� ����β������ ��
 * �����ȴ������ң��ٴ������������һ��������Դ����ƣ������֮�佻����У���
 * �����/���˼·��ʹ��˫ջ�����о���β������
 * ���룺�е�ƫ��
 */
public class Day28_zigzagLevelOrder {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        /* ����������� */
        if (root == null) return res;
        /* ʹ��˫ջ���� */
        Stack<TreeNode> leftToRight = new Stack<>(); // ���������˳��Ľڵ�
        Stack<TreeNode> rightToLeft = new Stack<>(); // ������ҵ���˳��Ľڵ�
        leftToRight.push(root);
        while (!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            if (!leftToRight.isEmpty()) {
                /* ���β�������Ǵ����ң���Ҫ����һ��ڵ���ҵ����� */
                while (!leftToRight.isEmpty()) {
                    TreeNode pop = leftToRight.pop();
                    level.add(pop.val);
                    if (pop.left != null) rightToLeft.push(pop.left);
                    if (pop.right != null) rightToLeft.push(pop.right);
                }
            } else {
                /* ���β�������Ǵ��ҵ�����Ҫ����һ��ڵ�����Ҵ�� */
                while (!rightToLeft.isEmpty()) {
                    TreeNode pop = rightToLeft.pop();
                    level.add(pop.val);
                    if (pop.right != null) leftToRight.push(pop.right);
                    if (pop.left != null) leftToRight.push(pop.left);
                }
            }
            res.add(level);
        }
        return res;
    }
}