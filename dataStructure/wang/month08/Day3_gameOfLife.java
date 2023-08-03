package month08;

/**
 * 时间：2023/8/3
 * 问题描述：
 *  给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *  如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 *  如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 *  如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 *  如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *  下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 *  进阶：使用原地算法解决本题
 * 切入点/解决思路：使用其他数字表示需要改变的状态
 * 感想：中等
 */
public class Day3_gameOfLife {

    /**
     * 该细胞原本处理存活状态，需要转为死亡状态
     */
    public static int LIVE_TO_DIE = -1;

    /**
     * 该细胞原本处于死亡状态，需要转为存活状态
     */
    public static int DIE_TO_LIVE = -2;


    /**
     * 只需要其他两个状态表示活转死，死转活即可
     */
    public void gameOfLife(int[][] board) {
        /* 特殊情况 */
        if (board == null || board.length == 0) return;
        /* 第一次遍历，更改所有需要变化状态的细胞临时状态 */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                deal(board, j, i);
            }
        }
        /* 将所有临时状态替换为诶最终状态 */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == LIVE_TO_DIE) board[i][j] = 0;
                else if (board[i][j] == DIE_TO_LIVE) board[i][j] = 1;
            }
        }
    }

    private void deal(int[][] board, int x, int y) {
        /* 统计该细胞周围 8 个细胞的存活数量 */
        int liveTotal = 0;
        int[][] helper = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < helper.length; i++) {
            int temY = y + helper[i][0];
            int temX = x + helper[i][1];
            if (temX >= 0 && temX < board[0].length && temY >= 0 && temY < board.length
                    && (board[temY][temX] == 1 || board[temY][temX] == LIVE_TO_DIE)) liveTotal++;
        }
        if (board[y][x] == 1 && (liveTotal < 2 || liveTotal > 3)) board[y][x] = LIVE_TO_DIE;
        else if (board[y][x] == 0 && liveTotal == 3) board[y][x] = DIE_TO_LIVE;
    }
}