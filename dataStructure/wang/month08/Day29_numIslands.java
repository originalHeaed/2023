package month08;

/**
 * ʱ�䣺2023/8/29
 * ����������
 *  ����һ���� '1'��½�أ��� '0'��ˮ����ɵĵĶ�ά����������������е����������
 *  �������Ǳ�ˮ��Χ������ÿ������ֻ����ˮƽ�����/����ֱ���������ڵ�½�������γɡ�
 *  ���⣬����Լ��������������߾���ˮ��Χ��
 * �����/���˼·��ʹ�ò�����������/�����������
 * ���룺�е�
 */
public class Day29_numIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        /* ����������� */
        if (grid == null || grid.length == 0) return res;
        /* Ѱ�ҵ������� */
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
     * �� (x,y) ���ڵĵ����ɺ���
     */
    private void helper(char[][] grid, int x, int y) {
        /* �ݹ�������� */
        if (x < 0 || x >= grid[0].length) return;
        if (y < 0 || y >= grid.length) return;
        if (grid[y][x] == '0') return;
        /* �ݹ��� */
        grid[y][x] = '0';
        helper(grid, x - 1, y);
        helper(grid, x + 1, y);
        helper(grid, x, y - 1);
        helper(grid, x, y + 1);
    }
}