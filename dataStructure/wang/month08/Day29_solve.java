package month08;

/**
 * ʱ�䣺2023/8/29
 * ����������
 *  ����һ�� m x n �ľ��� board ���������ַ� 'X' �� 'O' ��
 *  �ҵ����б� 'X' Χ�Ƶ����򣬲�����Щ���������е� 'O' �� 'X' ���
 * �����/���˼·������������� + ��Ƿ���������Ҫ�ı�Ͳ��øı�� O��
 * ���룺�е�
 */
public class Day29_solve {
    /**
     * ʱ�临�Ӷȣ�O��n��
     * �ռ临�Ӷȣ�O��n��
     */
    public void solve(char[][] board) {
        /* ����������� */
        if (board == null || board.length == 0 || board[0].length == 0) return;
        /* ������ֱ�ӻ�����߽�Ӵ��� O �����Ϊ 1 */
        byte[][] helper = new byte[board.length][board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            /* ���������� */
            helper(helper, board, i, 0);
            helper(helper, board, i, board.length - 1);
        }
        for (int i = 1; i < board.length - 1; i++) {
            /* ���������� */
            helper(helper, board, 0, i);
            helper(helper, board, board[0].length - 1, i);
        }
        /* �����зǱ�ǵĽڵ���Ϊ X */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper[i][j] != 1) board[i][j] = 'X';
            }
        }
    }

    /**
     * �������� (x,y) �����ӵ����� O ��־λ��Ϊ 1
     */
    private void helper(byte[][] helper, char[][] board, int x, int y) {
        /* �ݹ�������� */
        if (x < 0 || x >= board[0].length) return;
        if (y < 0 || y >= board.length) return;
        if (board[y][x] == 'X' || helper[y][x] == 1) return; // �� O �ڵ���߸ýڵ��Ѿ������
        /* ���еݹ� */
        helper[y][x] = 1;
        helper(helper, board, x - 1, y);
        helper(helper, board, x + 1, y);
        helper(helper, board, x, y - 1);
        helper(helper, board, x, y + 1);

    }
}