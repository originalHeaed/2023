package month08;

/**
 * 时间：2023/8/29
 * 问题描述：
 *  给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *  岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *  此外，你可以假设该网格的四条边均被水包围。
 * 切入点/解决思路：使用层序优先搜索/深度优先搜索
 * 感想：中等
 */
public class Day29_numIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        /* 特殊情况处理 */
        if (grid == null || grid.length == 0) return res;
        /* 寻找岛屿数量 */
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    helper(grid, j, i);
                }
            }
        }
        return res;
    }

    /**
     * 将 (x,y) 所在的岛屿变成海洋
     */
    private void helper(char[][] grid, int x, int y) {
        /* 递归结束条件 */
        if (x < 0 || x >= grid[0].length) return;
        if (y < 0 || y >= grid.length) return;
        if (grid[y][x] == '0') return;
        /* 递归体 */
        grid[y][x] = '0';
        helper(grid, x - 1, y);
        helper(grid, x + 1, y);
        helper(grid, x, y - 1);
        helper(grid, x, y + 1);
    }
}