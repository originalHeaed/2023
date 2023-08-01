package month08;

/**
 * ʱ�䣺2023/8/1
 * ����������
 *  ����һ�� n �� n �Ķ�ά���� matrix ��ʾһ��ͼ�����㽫ͼ��˳ʱ����ת 90 �ȡ�
 *  ������� ԭ�� ��תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫ ʹ����һ����������תͼ��
 * �����/���˼·������У��ȴ�����㣬Ȼ����ڲ���Ϊһ��Ŀ���ڽ��д���
 * ���룺�е�
 */
public class Day02_rotate {
    /**
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��1��
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < (len / 2); i++) {
            helper(matrix, len - (i * 2), i, i);
        }
    }

    /**
     * �� (x, y) ��Ϊ��㣬����Ϊ n �γ�һ�� n*n �ľ���Ȼ��ѡ��þ���������
     */
    private void helper(int[][] matrix, int len, int x, int y) {
        int maxX = x + len - 1;
        int maxY = y + len - 1;
        int step = len - 1; // ÿ����תһ�Σ�һ��Ԫ�ؾ������ٸ�����Ԫ��
        /* �� [x,y]��[x + 1, y]��[x + 2, y] ... [x + len - 2, y] �⼸����Ϊ��������ת���ɴﵽ��ת��������Ŀ�� */
        for (int i = 0; i < (len - 1); i++) {
            /* ���Ը��� ��x, y�� ������λ�����ƶ������Ǵ��������������ˣ�����ֱ���ƶ�����Ҫ��ת�Ĵμ��ɡ� */
            int temX = x + i;
            int temY = y;
            int temVal = matrix[temY][temX];
            /* ��һ��˳ʱ����ת 90 �� */
            temY += step - maxX + temX; // ��� x ���������� len - 1������Ҫʹ�� y ������
            temX = Math.min(temX + step, maxX);
            matrix[temY][temX] = matrix[temY][temX] ^ temVal;
            temVal = matrix[temY][temX] ^ temVal;
            matrix[temY][temX] = matrix[temY][temX] ^ temVal;
            /* �ڶ���˳ʱ����ת 90 �� */
            temX -= step - maxY + temY; // ������� y ���Ӵﵽ�����ֵ������Ҫ x ����
            temY = Math.min(temY + step, maxY);
            matrix[temY][temX] = matrix[temY][temX] ^ temVal;
            temVal = matrix[temY][temX] ^ temVal;
            matrix[temY][temX] = matrix[temY][temX] ^ temVal;
            /* ������˳ʱ��ת 90 �� */
            temY -= step - temX + x; // ��� x �����ƶ�Ԫ�ز��� len - 1������Ҫ y �����ƶ�
            temX = Math.max(temX - step, x);
            matrix[temY][temX] = matrix[temY][temX] ^ temVal;
            temVal = matrix[temY][temX] ^ temVal;
            matrix[temY][temX] = matrix[temY][temX] ^ temVal;
            /* ���Ĵ�˳ʱ����ת 90 �ȣ����һ�Σ���ص�ԭ�㣩 */
            matrix[y][x + i] = temVal;
        }
    }

    public static void main(String[] args) {
        Day02_rotate rotate = new Day02_rotate();
        rotate.helper(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}, 2, 1 ,1);
    }
}