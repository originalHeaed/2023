package month01;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Day06 {
    //=========================================== 序列化和反序列化二叉搜索树 ===============================================

    /**
     * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，
     * 或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
     * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。
     * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
     */
    /**
     * 对二叉搜索树使用前序遍历 + () 形式
     */
    public String serialize(TreeNode root) {
        /* 特殊情况处理 */
        if (root == null) return "";
        String left = serialize(root.left);
        String right = serialize(root.right);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (!"".equals(left) || !"".equals(right)) sb.append("(").append(left).append(")");
        if (!"".equals(right)) sb.append("(").append(right).append(")");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Map<Integer, Integer> map = new HashMap<>();/* 记录每一个左括号与对应匹配的右括号 */
        data = "(" + data + ")";
        char[] chars = data.toCharArray();
        /* 记录每一个每一个左括号匹配的右括号下标 */
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') stack.push(i);
            else if (chars[i] == ')') {
                map.put(stack.pop(), i);
            }
        }
        /* 还原二叉搜索树 */
        return recoverTree(chars, 0, chars.length - 1, map);
    }

    /**
     * 使用递归还原
     */
    private TreeNode recoverTree(char[] chars, int left, int right, Map<Integer, Integer> map) {
        /* 递归结束条件 */
        if (right - left <= 1) return null;
        /* 获取当前节点的 val */
        int val = 0;
        while (chars[++left] != '(' && chars[left] != ')') {
            val *= 10;
            val += (chars[left] - '0');
        }
        TreeNode treeNode = new TreeNode(val);
        treeNode.left = recoverTree(chars, left, map.getOrDefault(left, left), map);
        if (chars[left] == '(') left = map.get(left) + 1;
        treeNode.right = recoverTree(chars, left, right - 1, map);
        return treeNode;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //=============================================== 验证二叉树的前序序列化 ==============================================
    /**
     * 序列化二叉树的一种方法是使用 前序遍历 。
     * 当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
     * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
     * 保证 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
     */
    public boolean isValidSerialization(String preorder) {
        return false;
    }
}
