package month08;

/**
 * ʱ�䣺2023/8/3
 * ����������
 *  ����һ������ m �� n �����ӵ���壬ÿһ�����Ӷ����Կ�����һ��ϸ����ÿ��ϸ��������һ����ʼ״̬�� 1 ��Ϊ ��ϸ�� ��live������ 0 ��Ϊ ��ϸ�� ��dead����ÿ��ϸ������˸�����λ�ã�ˮƽ����ֱ���Խ��ߣ���ϸ������ѭ�����������涨�ɣ�
 *  �����ϸ����Χ�˸�λ�õĻ�ϸ�����������������λ�û�ϸ��������
 *  �����ϸ����Χ�˸�λ����������������ϸ�������λ�û�ϸ����Ȼ��
 *  �����ϸ����Χ�˸�λ���г���������ϸ�������λ�û�ϸ��������
 *  �����ϸ����Χ������������ϸ�������λ����ϸ�����
 *  ��һ��״̬��ͨ������������ͬʱӦ���ڵ�ǰ״̬�µ�ÿ��ϸ�����γɵģ�����ϸ���ĳ�����������ͬʱ�����ġ����� m x n ������� board �ĵ�ǰ״̬��������һ��״̬��
 *  ���ף�ʹ��ԭ���㷨�������
 * �����/���˼·��ʹ���������ֱ�ʾ��Ҫ�ı��״̬
 * ���룺�е�
 */
public class Day3_gameOfLife {

    /**
     * ��ϸ��ԭ��������״̬����ҪתΪ����״̬
     */
    public static int LIVE_TO_DIE = -1;

    /**
     * ��ϸ��ԭ����������״̬����ҪתΪ���״̬
     */
    public static int DIE_TO_LIVE = -2;


    /**
     * ֻ��Ҫ��������״̬��ʾ��ת������ת���
     */
    public void gameOfLife(int[][] board) {
        /* ������� */
        if (board == null || board.length == 0) return;
        /* ��һ�α���������������Ҫ�仯״̬��ϸ����ʱ״̬ */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                deal(board, j, i);
            }
        }
        /* ��������ʱ״̬�滻Ϊ������״̬ */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == LIVE_TO_DIE) board[i][j] = 0;
                else if (board[i][j] == DIE_TO_LIVE) board[i][j] = 1;
            }
        }
    }

    private void deal(int[][] board, int x, int y) {
        /* ͳ�Ƹ�ϸ����Χ 8 ��ϸ���Ĵ������ */
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