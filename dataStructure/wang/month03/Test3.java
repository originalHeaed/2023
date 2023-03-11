package month03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test3 {
    public static int res = 0;

    /**
     * 时间复杂度：O（n）
     */
    public static int recurse(List<Integer> list) {
        int[] levelCount = new int[31]; /* 第一位为 1 的数字统计 */
        /* 统计每一个数字的最高位 */
        for(int val : list) {
            int level = 30;
            while (level >= 0 && ((val >>> level) % 2) == 0) level--;
            levelCount[level + 1]++;
        }
        /* 获取结果 */
        int res = 0;
        int total = list.size();
        for (int i = levelCount.length - 1; i >= 0; i--) {
            total -= levelCount[i];
            res += (levelCount[i] * total);
        }
        return res;

    }

    /**
     *
     */
    public static void main(String[] args) {
        /* 获取输入 */
//        Scanner scanner = new Scanner(System.in);
//        int total = scanner.nextInt();
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < total; i++) {
//            list.add(scanner.nextInt());
//        }
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(4);
        /* 获取结果 */
        System.out.println(recurse(list));
    }
}
