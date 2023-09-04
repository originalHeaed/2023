package month09;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * ʱ�䣺2023/9/4
 * ����������
 * һ���������̣���1�ߵ���β��ÿ��ֻ��˦����1-6��
 * ��������-1��ֵҲ���ǣ��߻���¥�ݣ�������ת����Ӧֵ��λ�ã���������Ҫ���������յ�
 * �����/���˼·���������������Ϊһ������ͼ��ʹ�ù�����������ҵ����·��
 * ���룺�е�ƫ��
 */
public class Day04_snakesAndLadders {

    private int MAX_STEP = 6;

    /**
     * ʱ�临�Ӷȣ�O��n��
     * �ռ临�Ӷȣ�O��n��
     * @param board
     * @return
     */
    public int snakesAndLadders(int[][] board) {
        /* ����������� */
        if (board == null || board.length == 0 || (board.length == 1 && board[1].length == 1)) return 0;
        /* ��ʼ���й���������� */
        int res = 0;
        Queue<Integer> queue = new LinkedList<>(); // ��������
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
     * �� [val+1, val+6] ���뵽������
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