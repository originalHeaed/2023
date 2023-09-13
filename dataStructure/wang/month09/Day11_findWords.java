package month09;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 时间：2023/9/11
 * 问题描述：
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * 切入点/解决思路：构建一个字典树，然后在字典树中进行查找
 * 感想：困难
 */
public class Day11_findWords {
    int[][] ARR = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 树节点
     */
    class TreeNode {
        Map<Character, TreeNode> map;
        char val;

        public TreeNode(char c) {
            map = new HashMap<>(30);
            this.val = c;
        }
    }

    /**
     * 时间复杂度：O（n^2 + m）
     * 空间复杂度：O（n）
     *
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        /* 特殊情况处理 */
        if (board == null || board.length == 0 || words == null || words.length == 0) return new LinkedList<>();
        /* 构建前缀树 */
        TreeNode root = new TreeNode(' ');
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                buildTrie(j, i, board, new boolean[board.length][board[0].length], root, 1);
            }
        }
        /* 在前缀树中查找 */
        List<String> res = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if (helper(root, 0, words[i])) res.add(words[i]);
        }
        return res;
    }

    /**
     * 递归构建前缀树
     */
    private void buildTrie(int x, int y, char[][] board, boolean[][] isVisit, TreeNode parent, int dep) {
        if (x < 0 || x >= board[0].length || y < 0 || y >= board.length || isVisit[y][x] || dep > 10) return;
        parent.map.putIfAbsent(board[y][x], new TreeNode(board[y][x]));
        TreeNode node = parent.map.get(board[y][x]);
        isVisit[y][x] = true;
        for (int i = 0; i < ARR.length; i++) {
            buildTrie(x + ARR[i][0], y + ARR[i][1], board, isVisit, node, dep + 1);
        }
        isVisit[y][x] = false;
    }

    /**
     * 递归判断单词是否在前缀树中
     */
    private boolean helper(TreeNode root, int index, String s) {
        if (index >= s.length()) return true;
        if (!root.map.containsKey(s.charAt(index))) return false;
        return helper(root.map.get(s.charAt(index)), index + 1, s);
    }
}