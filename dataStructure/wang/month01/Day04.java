package month01;


import sun.reflect.generics.tree.Tree;

public class Day04 {
    //=============================== 单词的压缩编码 ===================================

    /**
     * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
     * words.length == indices.length
     * 助记字符串 s 以 '#' 字符结尾
     * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
     * 给你一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
     */

    private int res = 0;
    /**
     * 使用树保存每一个单子，每个节点保存一个字母，关键点：树中单词存储是逆序的
     */
    public int minimumLengthEncoding(String[] words) {
        /* 特殊情况处理 */
        if (words == null || words.length == 0) return 1;
        /* 构建树 */
        TreeNode root = new TreeNode();
        for (String s : words) {
            char[] chars = s.toCharArray();
            buildTree(root, chars, chars.length - 1);
        }
        return res;
    }

    /**
     * 递归将 arr 所代表的字符串放入树中
     * @param node
     * @param arr
     * @param index
     */
    private void buildTree(TreeNode node, char[] arr, int index) {
        /* 递归结束条件 */
        if (index < 0 || arr.length == 0) return;
        /* 递归体 */
        if (node.nodes == null || node.nodes[arr[index] - 'a'] == null) { /* 需要创建新的节点 */
            if (node.len != -1 && node.nodes == null) {
                res -= node.len;
            }
            if (node.nodes == null) node.nodes = new TreeNode[26];
            TreeNode tem = new TreeNode();
            /* 需要创建新节点且遍历到该单词的首字母，则将该单词加入结果长途中 */
            if (index == 0) {
                tem.len = arr.length + 1;
                res += tem.len;
            }
            node.nodes[arr[index] - 'a'] = tem;
        } else {
            /* 节点已经存在 */
            if (index == 0) node.nodes[arr[index] - 'a'].len = arr.length + 1; // 更新最后一个节点的 len
        }
        buildTree(node.nodes[arr[index] - 'a'], arr, index - 1);
    }

    class TreeNode {
        /**
         * 保存子节点
         */
        TreeNode[] nodes;

        /**
         * 如果当前节点是一个字符串的开始，则 len 表示从根节点到当前节点路径上经过的总节点数
         */
        int len;

        public TreeNode() {
            this.len = -1;
        }

    }
}