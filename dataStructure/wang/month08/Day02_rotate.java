package month08;

/**
 * 时间：2023/8/1
 * 问题描述：
 *  给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *  你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 切入点/解决思路：剥洋葱，先处理外层，然后把内层作为一个目标在进行处理
 * 感想：中等
 */
public class Day02_rotate {
    /**
     * 时间复杂度：O（n），空间复杂度：O（1）
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < (len / 2); i++) {
            helper(matrix, len - (i * 2), i, i);
        }
    }

    /**
     * 以 (x, y) 作为起点，长度为 n 形成一个 n*n 的矩阵，然后选择该矩阵的最外层
     */
    private void helper(int[][] matrix, int len, int x, int y) {
        int maxX = x + len - 1;
        int maxY = y + len - 1;
        int step = len - 1; // 每次旋转一次，一个元素经历多少个其他元素
        /* 以 [x,y]、[x + 1, y]、[x + 2, y] ... [x + len - 2, y] 这几个作为起点进行旋转即可达到旋转整个外层的目的 */
        for (int i = 0; i < (len - 1); i++) {
            /* 可以根据 （x, y） 所处的位置来移动，但是代码量反而更多了，不如直接移动《需要旋转四次即可》 */
            int temX = x + i;
            int temY = y;
            int temVal = matrix[temY][temX];
            /* 第一次顺时针旋转 90 度 */
            temY += step - maxX + temX; // 如果 x 不足以消耗 len - 1，则需要使用 y 来消耗
            temX = Math.min(temX + step, maxX);
            matrix[temY][temX] = matrix[temY][temX] ^ temVal;
            temVal = matrix[temY][temX] ^ temVal;
            matrix[temY][temX] = matrix[temY][temX] ^ temVal;
            /* 第二次顺时针旋转 90 度 */
            temX -= step - maxY + temY; // 如果向下 y 增加达到了最大值，则需要 x 左移
            temY = Math.min(temY + step, maxY);
            matrix[temY][temX] = matrix[temY][temX] ^ temVal;
            temVal = matrix[temY][temX] ^ temVal;
            matrix[temY][temX] = matrix[temY][temX] ^ temVal;
            /* 第三次顺时旋转 90 度 */
            temY -= step - temX + x; // 如果 x 向左移动元素不够 len - 1，则需要 y 向上移动
            temX = Math.max(temX - step, x);
            matrix[temY][temX] = matrix[temY][temX] ^ temVal;
            temVal = matrix[temY][temX] ^ temVal;
            matrix[temY][temX] = matrix[temY][temX] ^ temVal;
            /* 第四次顺时针旋转 90 度（最后一次，会回到原点） */
            matrix[y][x + i] = temVal;
        }
    }

    public static void main(String[] args) {
        Day02_rotate rotate = new Day02_rotate();
        rotate.helper(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}, 2, 1 ,1);
    }
}