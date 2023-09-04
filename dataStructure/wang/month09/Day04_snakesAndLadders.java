package month09;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 时间：2023/9/4
 * 问题描述：
 * 一个蛇形棋盘，从1走到结尾，每次只能甩骰子1-6，
 * 遇到不是-1的值也就是（蛇或者楼梯）可以跳转到相应值的位置，问最少需要几步到达终点
 * 切入点/解决思路：将整个棋盘理解为一个有向图，使用广度优先搜索找到最短路径
 * 感想：中等偏上
 */
public class Day04_snakesAndLadders {

    private int MAX_STEP = 6;

    /**
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     * @param board
     * @return
     */
    public int snakesAndLadders(int[][] board) {
        /* 特殊情况处理 */
        if (board == null || board.length == 0 || (board.length == 1 && board[1].length == 1)) return 0;
        /* 开始进行广度优先搜索 */
        int res = 0;
        Queue<Integer> queue = new LinkedList<>(); // 辅助队列
        Set<Integer> isVisit = new HashSet<>();
        helper(1, board, queue, isVisit);
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll >= board.length * board.length) return res;
                else helper(poll, board, queue, isVisit);
            }
        }

        return -1;
    }

    /**
     * 将 [val+1, val+6] 加入到队列中
     */
    private void helper(int val, int[][] board, Queue<Integer> queue, Set<Integer> isVisit) {
        isVisit.add(val);
        for (int i = val + 1; i <= val + MAX_STEP; i++) {
            if (i >= board.length * board.length) {
                queue.add(i);
                return;
            }
            int y = board.length - 1 - ((i - 1) / board.length);
            int x = (board.length - 1) % 2 == (y % 2) ?  (i - 1) % board.length : ((board.length - 1) - (i -1) % board.length);
            int tem = i;
            if (board[y][x] != -1) {
                tem = board[y][x];
            }
            if (!isVisit.contains(tem)) {
                isVisit.add(tem);
                queue.add(tem);
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,1,-1},{1,1,1},{-1,1,1}};
        Day04_snakesAndLadders day04_snakesAndLadders = new Day04_snakesAndLadders();
        System.out.println(day04_snakesAndLadders.snakesAndLadders(test));
    }
}