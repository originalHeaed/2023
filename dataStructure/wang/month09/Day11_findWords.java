package month09;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * ʱ�䣺2023/9/11
 * ����������
 * ����һ�� m x n ��ά�ַ����� board ��һ�����ʣ��ַ������б� words�� �������ж�ά�����ϵĵ��� ��
 * ���ʱ��밴����ĸ˳��ͨ�� ���ڵĵ�Ԫ�� �ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��
 * ͬһ����Ԫ���ڵ���ĸ��һ�������в������ظ�ʹ�á�
 * �����/���˼·������һ���ֵ�����Ȼ�����ֵ����н��в���
 * ���룺����
 */
public class Day11_findWords {
    int[][] ARR = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * ���ڵ�
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
     * ʱ�临�Ӷȣ�O��n^2 + m��
     * �ռ临�Ӷȣ�O��n��
     *
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        /* ����������� */
        if (board == null || board.length == 0 || words == null || words.length == 0) return new LinkedList<>();
        /* ����ǰ׺�� */
        TreeNode root = new TreeNode(' ');
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                buildTrie(j, i, board, new boolean[board.length][board[0].length], root, 1);
            }
        }
        /* ��ǰ׺���в��� */
        List<String> res = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if (helper(root, 0, words[i])) res.add(words[i]);
        }
        return res;
    }

    /**
     * �ݹ鹹��ǰ׺��
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
     * �ݹ��жϵ����Ƿ���ǰ׺����
     */
    private boolean helper(TreeNode root, int index, String s) {
        if (index >= s.length()) return true;
        if (!root.map.containsKey(s.charAt(index))) return false;
        return helper(root.map.get(s.charAt(index)), index + 1, s);
    }
}