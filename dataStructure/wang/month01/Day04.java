package month01;


import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.UUID;

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

    //========================================== TinyURL 的加密与解密 ==================================

    /**
     * TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。
     * 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本的 URL 。
     * 实现 Solution 类：
     * Solution() 初始化 TinyURL 系统对象。
     * String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
     * String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系统对象加密的。
     */

    /**
     * 用于保存数据
     */
    private HashMap<String, String> map = new HashMap<>();

    /**
     * 编码
     * @param longUrl
     * @return
     */
    public String encode(String longUrl) {
        UUID myUuid = UUID.randomUUID();
        while (map.containsKey(myUuid.toString())) {
            myUuid = UUID.randomUUID();
        }
        map.put(myUuid.toString(), longUrl);
        return myUuid.toString();
    }

    /**
     * 解码
     * @param shortUrl
     * @return
     */
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    //======================================= 解码字母到整数映射 ======================================

    /**
     * 给你一个字符串  s，它由数字（'0' - '9'）和  '#'  组成。我们希望按下述规则将  s  映射为一些小写英文字符：
     * 字符（'a' - 'i'）分别用（'1' -  '9'）表示。
     * 字符（'j' - 'z'）分别用（'10#'  -  '26#'）表示。  
     * 返回映射之后形成的新字符串。
     * 题目数据保证映射始终唯一。
     */
    /**
     * 从后到前进行处理即可（反向处理）
     */
    public String freqAlphabets(String s) {
        /* 特殊情况处理 */
        if (s == null || s.length() == 0) return "";
        /* 获取映射后的内容 */
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0 ; i--) {
            char val = ' ';
            if (chars[i] == '#') {
                val = (char) ('a' + Integer.valueOf("" + chars[i - 2] + chars[i - 1]) - 1);
                i -= 2;
            } else {
                val = (char) ('a' + chars[i] - '0' - 1);
            }
            sb.append(val);
        }
        return sb.reverse().toString();
    }
}