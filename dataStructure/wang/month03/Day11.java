package month03;

import java.util.*;

public class Day11 {
    //================================== 从上到下打印二叉树 ===========================
    /**
     * 使用层序遍历，使用队列
     */

    public int[] levelOrder(TreeNode root) {
        /* 特殊情况判断 */
        if (root == null) return new int[0];
        /* 进行层序遍历 */
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null)queue.add(node.left);
                if (node.right!= null)queue.add(node.right);
                size--;
            }
        }
        /* 结果转换 */
        int[] arr = new int[res.size()];
        int index = 0;
        for (int val : res) arr[index++] = val;
        return arr;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    //============================================= 从单链表中删除指定值的节点 ======================

    /**
     * 使用指针完成该题
     */
    public static void helper1() {
        /* 1. 读取输入流 */
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt(); // 总节点数
        int begin = scanner.nextInt(); // 头节点
        int[] index = new int[10001]; // 每个值不重复，且 [0, 10000]，直接使用数组来位置节点关系
        Arrays.fill(index, -1);
        int targetPre = -1; // 待删除目标节点的前置节点坐标
        /* 2. 进行连接操作 */
        for (int i = 0; i < (total - 1); i++) {
            int next = scanner.nextInt();
            int pre = scanner.nextInt();
            index[next] = index[pre];
            index[pre] = next;
        }
        int target = scanner.nextInt(); // 待删除的节点
        /* 3. 断开 */
        if (begin == target) begin = index[begin];
        else {
            int idx = begin;
            while (index[idx] != target) {
                idx = index[idx];
            }
            index[idx] = index[target];
        }
        /* 4. 输出结果 */
        do {
            System.out.print(begin + " ");
            begin = index[begin];
        } while (begin != -1);
    }

}
