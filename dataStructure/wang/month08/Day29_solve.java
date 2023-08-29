package month08;

/**
 * 时间：2023/8/29
 * 问题描述：
 *  给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，
 *  找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
 * 切入点/解决思路：深度优先搜索 + 标记法（区分需要改变和不用改变的 O）
 * 感想：中等
 */
public class Day29_solve {
    /**
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    public void solve(char[][] board) {
        /* 特殊情况处理 */
        if (board == null || board.length == 0 || board[0].length == 0) return;
        /* 将所有直接或间接与边界接触的 O 标记置为 1 */
        byte[][] helper = new byte[board.length][board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            /* 上下两条边 */
            helper(helper, board, i, 0);
            helper(helper, board, i, board.length - 1);
        }
        for (int i = 1; i < board.length - 1; i++) {
            /* 左右两条边 */
            helper(helper, board, 0, i);
            helper(helper, board, board[0].length - 1, i);
        }
        /* 将所有非标记的节点置为 X */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper[i][j] != 1) board[i][j] = 'X';
            }
        }
    }

    /**
     * 将所有与 (x,y) 相连接的所有 O 标志位置为 1
     */
    private void helper(byte[][] helper, char[][] board, int x, int y) {
        /* 递归结束条件 */
        if (x < 0 || x >= board[0].length) return;
        if (y < 0 || y >= board.length) return;
        if (board[y][x] == 'X' || helper[y][x] == 1) return; // 非 O 节点或者该节点已经被标记
        /* 进行递归 */
        helper[y][x] = 1;
        helper(helper, board, x - 1, y);
        helper(helper, board, x + 1, y);
        helper(helper, board, x, y - 1);
        helper(helper, board, x, y + 1);

    }
}