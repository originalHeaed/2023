package month03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    /**
     * 不使用双指针
     * @param arr
     * @return
     */
    public static int helper(int[] arr) {
        /* 特殊情况考虑 */
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1) return 0;
        /* 获取中心下标 */
        int[] leftCount = new int[arr.length]; // leftCount[i] = leftCount[0] * leftCount[1] ... leftCount[i - 2]
        int[] rightCount = new int[arr.length]; // rightCount[i] = rightCount[i + 1] * rightCount[i +2] * ... rightCount[rightCount.length - 1]
        /* 初始化 leftCount */
        int left = 0;
        leftCount[left++] = 1;
        while (left < leftCount.length) {
            leftCount[left] = arr[left - 1] * leftCount[left - 1];
            left++;
        }
        /* 初始化 rightCount */
        int right = rightCount.length - 1;
        rightCount[right--] = 1;
        while (right >= 0) {
            rightCount[right] = arr[right + 1] * rightCount[right + 1];
            right--;
        }
        /* 对比 leftCount 和 rightCount,获取第一个值相同的下标 */
        for (int i = 0; i < leftCount.length; i++) {
            if (leftCount[i] == rightCount[i]) return i;
        }
        return -1; // 不存在
    }

    public static void main(String[] args) {
        /* 获取数据 */
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        /* 获取坐标 */
        int helper = helper(arr);
        System.out.println(helper);
    }
}
