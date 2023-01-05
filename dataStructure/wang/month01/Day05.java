package month01;

import java.nio.charset.Charset;

public class Day05 {
    //============================================== UTF-8 编码验证 ==========================================

    /**
     * 给定一个表示数据的整数数组 data ，返回它是否为有效的 UTF-8 编码。
     * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
     * 对于 1 字节 的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
     * 对于 n 字节 的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，后面字节的前两位一律设为 10 。
     * 剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
     */
    /**
     * 使用暴力法验证
     * @param data
     * @return
     */
    public boolean validUtf8(int[] data) {
        /* 特殊情况处理 */
        if (data == null || data.length == 0) return false;
        /* 校验字符是否为 utf-8 */
        int i = 0;
        int len = 0;
        while (i < data.length) {
            if (len > 0) {
                /* 上一个字符尚未结束 */
                if ((data[i] >>> 6) != 2) return false; // 该字节不以 10 开头
                len--;
            } else {
                /* 获取字符第一个字节中前导 1 个数量 */
                int tem = 0;
                while (len < 8) {
                    tem <<= 1;
                    tem += 1;
                    if ((data[i] >>> (8 - len - 1)) != tem) break;
                    len++;
                }
                /* 前导 1 的个数为 1 或者大于 4 都是异常 */
                if (len == 1 || len > 4) return false;
                if (len > 0) len--;
            }
            i++;
        }
        return len == 0;
    }

    //================================================= 根据二叉树创建字符串 =============================================
    /**
     * 给你二叉树的根节点 root ，请你采用前序遍历的方式，将二叉树转化为一个由括号和整数组成的字符串，返回构造出的字符串。
     * 空节点使用一对空括号对 "()" 表示，转化后需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     */
    /**
     * 使用递归解决
     */
    public String tree2str(TreeNode root) {
        /* 递归结束条件 */
        if (root == null) return "";
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (!"".equals(right) || !"".equals(left)) sb.append("(").append(left).append(")");
        if (!"".equals(right)) sb.append("(").append(right).append(")");
        return sb.toString();
    }

    class TreeNode {
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
