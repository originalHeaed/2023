package month03;

import java.util.*;

public class Day09 {
    //======================== 将十六进制转为十进制 ==============================================
    /**
     * 将十六进制转为十进制，时间复杂度 O（n），空间复杂度：O（n）
     * @param val 十六进制内容，val 是去掉 Ox 之后的内容
     * @return
     */
    public static int helper(String val) {
        /* 将十六进制进行分割 */
        char[] c = val.toCharArray();
        int temp = 1;
        int res = 0;
        /* 从后向前处理每一个十六进制数字 */
        for (int i = c.length - 1; i >= 0; --i) {
            int count = 0;
            if ('0' <= c[i] && c[i] <= '9') {
                /* 直接不用进行转换 */
                count = temp * (c[i] - '0');
            } else {
                /* 将字母与数字进行转换（支持大小写） */
                if ('a' <= c[i] && c[i] <= 'z') count = temp * (c[i] - 'a' + 10);
                else count = temp * (c[i] - 'A' + 10);
            }
            res += count;
            temp *= 16;
        }
        return res;
    }

    /**
     * 将十六进制转为十进制，时间复杂度 O（n），空间复杂度：O（n）
     * 直接做到一个通用的
     * @param val 十六进制内容，val 是去掉 Ox 之后的内容
     * @return
     */
    public static int helper2(String val, int base) {
        /* 特殊情况处理 */
        if (val == null || "".equals(val)) return 0;
        /* 将十六进制进行分割 */
        int res = 0;
        /* 从后向前处理每一个十六进制数字 */
        for (char c : val.toCharArray()) {
            int count = 0;
            if ('0' <= c && c <= '9') {
                /* 直接不用进行转换 */
                count = c - '0';
            } else {
                /* 将字母与数字进行转换（支持大小写） */
                if ('a' <= c && c <= 'z') count = c - 'a' + 10;
                else count = c - 'A' + 10;
            }
            res = res * base + count;
        }
        return res;
    }

    //=================================== 将十进制转为十六进制 ==========================================
    /**
     * 十进制转为其他进制
     * @param val
     * @return
     */
    public static String heper3(int val, int base) {
        /* 特殊情况处理 */
        if (val <= 0 || base <= 0) return "";
        /* 数据处理 */
        List<Integer> list = new ArrayList<>();
        while (val > 0) {
            int tem = val % base;
            list.add(tem);
            val = (val - tem) / base;
        }
        /* 反转数据 */
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    //============================== 明明的随机数 ===================================
    /**
     * 给出一个 n 个 1-500 的随机数，其中 n 的数量在 1-1000 之间，删除其中的重复数字，然后在进行排序
     */
    /**
     * 直接创建一个长度为 501 的数组，然后使用该数组进行去重和排序
     * 这样做的好处时，只要样例的值在 1-500 之间，无论样例的总量有多大，时间复杂度始终为 O（n），这个时间复杂度主要发生在从输入
     * 流中读取样例
     */
    public static void heper4() {
        Scanner scanner = new Scanner(System.in);
        int[] target = new int[501];
        /* 接收并处理 */
        int tem = 0;
        int total = scanner.nextInt();
        while (total > 0) {
            tem = scanner.nextInt();
            target[tem] = 1;
            total--;
        }
        /* 数据结果 */
        for (int i = 0; i < target.length; i++) {
            if (target[i] == 1) System.out.println(i);
        }
    }

    //================================== 字符个数统计 ===============================================

    /**
     * 编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。
     * 不在范围内的不作统计。多个相同的字符只计算一次
     */
    /**
     * 就是一个 map 应用
     */
    public static void helper5() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        System.out.println(set.size());
    }


    //===================================== 两数之和 ============================================
    /**
     * 给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
     * （注：返回的数组下标从1开始算起，保证target一定可以由数组里面2个数字相加得到）
     */


    public static void main(String[] args) {
//        /* 创建输入输出 */
//        Scanner scanner = new Scanner(System.in);
//        /* 获取输入的十六进制数据 */
//        String s = scanner.nextLine();
//        /* 去掉首部两个字符 */
//        s = s.substring(2);
//        /* 进行转换 */
//        System.out.println(helper2(s, 2));
        System.out.println(heper3(10, 2));
    }
}
