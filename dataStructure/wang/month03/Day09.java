package month03;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static int[] helper6(int[] numbers, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>(); // 存放数组中元素值 - 下标

        int tem = 0;
        for (int i = 0; i < numbers.length; i++) {
            tem = target - numbers[i]; // 该元素需要的目标元素
            int index = valueToIndex.getOrDefault(tem, -11);
            if (index != -11) {
                return index > i ? new int[]{i + 1, index + 1} : new int[]{index + 1, i + 1};
            }
            valueToIndex.put(numbers[i], i);
        }
        /* 没有找到结果 */
        return null;
    }

    //========================================== 跳台阶 ========================================
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     */
    /**
     * 使用递归判断，时间复杂度：O（2^n），空间复杂度：O（2^2）
     * 会形成一颗二叉树，并且会出现大量重复计算
     * @param target
     * @return
     */
    public int jumpFloor(int target) {
        /* 递归结束条件 */
        if (target <= 2) return target;
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    /**
     * 使用 DP 完成该题
     * 时间复杂度：O（n），空间复杂度：O（1）
     * @param target
     * @return
     */
    public int jumpFloor2(int target) {
        /* 特殊情况判断 */
        if (target <= 2) return target;
        /* 使用动态规划 */
        int pre = 1;
        int next = 2;
        target -= 2;
        while (target > 0) {
            int tem = next;
            next = pre + tem;
            pre = tem;
            target--;
        }
        return next;
    }

    /**
     * 使用背包法完成该题
     * 时间复杂度：O（n），空间复杂度：O（n）
     * @param target
     * @return
     */
    public int jumpFloor3(int target) {
        /* 特殊情况判断 */
        if (target <= 2) return target;
        /* 使用数组缓存，每一阶级的结果 */
        int[] help = new int[target + 1];
        help[1] = 1;
        help[2] = 2;
        for (int i = 3; i <= target; i++) {
            help[i] = help[i - 1] + help[i - 2];
        }
        return help[target];
    }


    //========================================= 坐标移动 ================================
    /**
     * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，
     * 从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
     */
    /**
     * 分割符号
     */
    public static final String SPLIT = ";";
    /**
     * 匹配的模式
     */
    public static final String PATTER = "^[A|W|D|S][0-9]{1,2}$";

    public static void helper7() {
        /* 读取输入流中数据 */
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        /* 使用指定分割符合分割 */
        String[] split = s.split(SPLIT, -1);
        int[] res = new int[2];
        /* 处理字符 */
        for (String tem : split) {
            deal(res, tem);
        }
        /* 输出处理结果 */
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(res[0]).append(',')
                .append(res[1]).append(')');
        System.out.println(sb);
    }

    /**
     * 使用正则表达式进行匹配
     * @param coordinate
     * @param val
     */
    public static void deal(int[] coordinate, String val) {
        /* 特殊情况不处理 */
        if (val == null || val.length() == 0) return;
        val = val.toUpperCase();
        /* 需要处理的字符串 */
        Pattern pattern = Pattern.compile(PATTER);
        Matcher matcher = pattern.matcher(val);
        if (!matcher.matches()) return;
        /* 获取移动方向 */
        char c = val.charAt(0);
        int step = Integer.valueOf(val.substring(1));
        if ('A' == c) coordinate[0] -= step;
        else if ('D' == c) coordinate[0] += step;
        else if ('W' == c) coordinate[1] += step;
        else coordinate[1] -= step;
    }

    /**
     * 使用自定义方法进行判断
     * @param coordinate
     * @param val
     */
    public static void deal2(int[] coordinate, String val) {
        /* 特殊情况不处理 */
        if (val == null || val.length() == 0) return;
        /* 判断是否符合条件 */
        val = val.toUpperCase();
        if (!isRight(val)) return;
        /* 获取移动方向 */
        char c = val.charAt(0);
        int step = Integer.valueOf(val.substring(1));
        if ('A' == c) coordinate[0] -= step;
        else if ('D' == c) coordinate[0] += step;
        else if ('W' == c) coordinate[1] += step;
        else coordinate[1] -= step;
    }


    public static boolean isRight(String val) {
        if (val == null || val.length() <= 1 || val.length() > 3) return false;
        char c = val.charAt(0);
        /* 判断第一个字符是否为 A/W/D/S */
        switch (c) {
            case 'A':
            case 'W':
            case 'D':
            case 'S':
                break;
            default:
                return false;
        }
        /* 判断后面字符是否为数字 */
        for (int i = 1; i < val.length(); i++) {
            if (val.charAt(i) < '0' || val.charAt(i) > '9') return false;
        }
        return true;
    }

    //============================================ 删除字符串中出现次数最少的字符 ================================

    /**
     * 先找出出现次数最少的字符集合，然后在遍历原字符串获取新的字符串
     * 纯纯的恶心人
     * 时间复杂度：O（n），空间复杂度：O（n）
     */
    public static void helper8() {
        /* 获取输入 */
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        /* 获取重复次数最少的字符集合 */
        int[] count = new int[26];
        Arrays.fill(count, 21);
        int minTime = Integer.MAX_VALUE; // 最少出现字符的个数
        for (char c : chars) {
            count[c - 'a']++;
        }
        for (int time : count) {
            minTime = Math.min(minTime, time);
        }
        Set<Character> set = new HashSet<>(); // 存放最少出现字符集合
        for (int i = 0; i < count.length; i++) {
            if (count[i] == minTime) set.add((char)('a' + i));
        }
        /* 除去重复次数最少的字符 */
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (!set.contains(c)) sb.append(c);
        }
        /* 输出结果 */
        System.out.println(sb);
    }

    //==================================== 整数与 IP 的相互转换 ========================
    public static final int N = 4;

    /**
     * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
     * 考点：进制转换，位运算
     */
    public static void helper9() {
        /* 读取数据 */
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        String digit = scanner.nextLine();
        /* 进行转换 */
        System.out.println(ipTodigit(ip));
        System.out.println(digitToIp(digit));
    }

    /**
     * 将 ip 转为数字
     * @param ip
     * @return
     */
    public static String ipTodigit(String ip) {
        String[] split = ip.split("\\.");
        long res = 0;
        for (int i = 0; i < split.length; i++) {
            res <<= 8;
            res |= Long.valueOf(split[i]); // 使用与运算符号
        }
        return String.valueOf(res);
    }

    /**
     * 将 ip 转为数字
     * @param ip
     * @return
     */
    public static String ipTodigit2(String ip) {
        String[] split = ip.split("\\.");
        long res = 0;
        for (int i = 0; i < split.length; i++) {
            res = res * 256 + Long.valueOf(split[i]); // 使用乘法运算
        }
        return String.valueOf(res);
    }


    /**
     * 将数组转为 ip
     * @param digit
     * @return
     */
    public static String digitToIp(String digit) {
        long val = Long.valueOf(digit);
        StringBuilder sb = new StringBuilder();
        int tem = 0b11111111000000000000000000000000;
        sb.append(((val & tem) >>> 24)).append(".");
        tem = (tem >>> 8);
        sb.append(((val & tem) >>> 16)).append(".");
        tem = (tem >>> 8);
        sb.append(((val & tem) >>> 8)).append(".");
        tem = (tem >>> 8);
        sb.append((val & tem));
        return sb.toString();
    }

    /**
     * 使用除法
     * @param digit
     * @return
     */
    public static String digitToIp2(String digit) {
        String s = "";
        long l = Long.valueOf(digit);
        for (int i = 0; i < N; i++) {
            s = (l % 256) + "." + s;
            l /= 256;
        }
        return s.substring(1, s.length() - 1);
    }



    public static void main(String[] args) {
//        /* 创建输入输出 */
//        Scanner scanner = new Scanner(System.in);
//        /* 获取输入的十六进制数据 */
//        String s = scanner.nextLine();
//        /* 去掉首部两个字符 */
//        s = s.substring(2);
//        /* 进行转换 */
//        System.out.println(helper2(s, 2));
//        System.out.println(heper3(10, 2));
        System.out.println(ipTodigit("10.0.3.193"));
        System.out.println(digitToIp("167969729"));
    }
}
