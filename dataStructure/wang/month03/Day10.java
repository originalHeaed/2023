package month03;

import java.util.*;

public class Day10 {
    //================================================ 输入整型数组和排序标识，对其元素按照升序或降序进行排序 =====================================================

    /**
     * 使用冒泡排序，时间复杂度：O（n^2）
     * @param arr 待排序的数组
     * @param asc 是否为升序，true 为升序排序，false 为降序拍戏
     */
    public static void sortMethod(int[] arr, boolean asc){
        /* 特殊情况处理 */
        if (arr == null || arr.length == 0) return;
        /* 使用冒泡排序法进行排序 */
        for (int i = 0; i < arr.length - 1; i++) {
            int index = arr.length - 1 - i;
            for (int j = 0; j < index; j++) {
                if ((arr[j] > arr[j + 1] && asc) || (arr[j] < arr[j + 1] && !asc)) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }

    /**
     * 使用选择排序，时间复杂度：O（n^2）
     * @param arr 待排序的数组
     * @param asc 是否为升序，true 为升序排序，false 为降序拍戏
     */
    public static void sortMethod2(int[] arr, boolean asc){
        /* 特殊情况处理 */
        if (arr == null || arr.length == 0) return;
        /* 使用选择排序 */
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[index] > arr[j] && asc) || (arr[index] < arr[j] && !asc)) {
                    index = j;
                }
            }
            if (index == i) continue;
            arr[i] = arr[i] ^ arr[index];
            arr[index] = arr[i] ^ arr[index];
            arr[i] = arr[i] ^ arr[index];
        }
    }

    /**
     * 使用选择排序，时间复杂度：O（nlogn）
     * 当原数据为降序，但是要求排序方式为升序时，没有打乱的前提下使用快速排序时间复杂度会降低为 O（n^2）
     * 因此使用快速排序时需要先将数据打乱，然后再进行排序，方能保持一个较好的时间复杂度；
     * 快排：递归 + 基数选择形成部分有序；
     * @param arr 待排序的数组
     * @param asc 是否为升序，true 为升序排序，false 为降序拍戏
     */
    public static void sortMethod3(int[] arr, boolean asc){
        /* 特殊情况处理 */
        if (arr == null || arr.length == 0) return;
        /* 使用快速排序 */
        quickSort(arr, 0, arr.length - 1, asc);
    }

    /**
     * 实现快速排序
     */
    public static void quickSort(int[] arr, int left, int right, boolean asc) {
        /* 递归结束条件 */
        if (left >= right) return;
        /* 递归体 */
        int l = left; // 左指针
        int r = right; // 右指针
        int base = arr[l]; // 基值
        while (l < r) {
            /* 从右到左查比 base 小的值或比 base 大的值（根据 asc 参数进行判断） */
            while (l < r && ((asc && arr[r] >= base) || (!asc && arr[r] <= base)) ) r--;
            /* 进行交换 */
            arr[l] = arr[r];
            /* 从左到右查比 base 大的值或比 base 小的值（根据 asc 参数进行判断） */
            while (l < r && ((asc && arr[l] <= base) || (!asc && arr[l] >= base))) l++;
            /* 进行交换 */
            arr[r] = arr[l];
        }
        arr[l] = base;
        quickSort(arr, left, l - 1, asc);
        quickSort(arr, l + 1, right, asc);
    }

    /**
     * 使用归并排序，时间复杂度：O（nlogn）
     * 归并排序：主要使用递归，每次递归回调后，将两个局部有序的数组合并成一个整体有序的数组；先递归然后合并（nice）
     * @param arr 待排序的数组
     * @param asc 是否为升序，true 为升序排序，false 为降序拍戏
     */
    public static void sortMethod4(int[] arr, boolean asc){
        /* 特殊情况处理 */
        if (arr == null || arr.length == 0) return;
        /* 使用快速排序 */
        mergeSort(arr, 0, arr.length - 1, asc);
    }

    /**
     * 实现快速排序
     */
    public static void mergeSort(int[] arr, int left, int right, boolean asc) {
        /* 递归结束条件 */
        if (left >= right) return;
        /* 递归体 */
        int mid = left + (right - left) / 2; // 中点
        /* 1. 先递归 */
        mergeSort(arr, left, mid, asc);
        mergeSort(arr, mid + 1, right, asc);
        /* 2. 后合并 */
        int[] tem = new int[right - left + 1];
        int index = 0;
        int r = mid + 1;
        int l = left;
        while (l <= mid && r <= right) {
            if ((asc && arr[l] > arr[r]) || (!asc && arr[l] < arr[r])) {
                tem[index++] = arr[r];
                r++;
            } else {
                tem[index++] = arr[l];
                l++;
            }
        }
        if (l > mid) {
            System.arraycopy(arr, r, tem, index, tem.length - index);
        } else {
            System.arraycopy(arr, l, tem, index, tem.length - index);
        }
        System.arraycopy(tem, 0, arr, left, tem.length);
    }

    /**
     * 使用桶排序，时间复杂度：O（n），本质是一个 hash 过程，只不过 hash 值不是随意取的，而是根据排序规则进行的，hash 值越大的数据
     * 排在前面，hash 值越小的数据，排在集合前面（以空间换时间）
     * 桶排序：创建多个桶，这些桶要能够容纳所有的 hash 值，然后将数据进行 hash 直接放在对应的桶中；
     * @param arr 待排序的数组
     * @param asc 是否为升序，true 为升序排序，false 为降序拍戏
     */
    public static void sortMethod5(int[] arr, boolean asc){
        /* 特殊情况处理 */
        if (arr == null || arr.length == 0) return;
        /* 使用桶排序 */
        bucketSort(arr);
        if (!asc) {
            int l = 0;
            int r = arr.length - 1;
            while (l < r) {
                arr[l] = arr[l] ^ arr[r];
                arr[r] = arr[l] ^ arr[r];
                arr[l] = arr[l] ^ arr[r];
                l++;
                r--;
            }
        }
    }

    /**
     * 实现桶排序
     */
    public static void bucketSort(int[] arr) {
        /* 创建能够容纳所有 hash 的集合对象 */
        int[] buckets = new int[100000]; // 根据题意，最大值不超过 100000
        /* 将数据放在桶中 */
        for (int val : arr) {
            buckets[val]++;
        }
        /* 将桶中有序的数据放回 arr */
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i] > 0) {
                arr[index++] = i;
                buckets[i]--;
            }
        }
    }

    public static void helper1() {
        /* 读入数据 */
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt(); // 数组长度
        int[] arr = new int[total];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        boolean asc = scanner.nextInt() == 0; // 是否升序
        /* 进行排序 */
        sortMethod(arr, asc);
        /* 输出结果 */
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(" ");
        }
    }


    //==================================== 字符串排序 =============================================
    /**
     * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
     */
    public static void helper2() {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.valueOf(scanner.nextLine()); // 字符串总数
        String[] arr = new String[total];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextLine();
        }
        /* 进行排序 */
        sortString(arr, new Comparator<String>() {
            /**
             * 比较两个字符串（使用自然排序）
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return 1：o1 > o2，0：o1 == o2，-1：o1 < o2
             */
            @Override
            public int compare(String o1, String o2) {
                /* 特殊情况 */
                if (o1 == null && o2 == null) return 0;
                if (o1 == null) return -1;
                if (o2 == null) return 1;
                char[] chars1 = o1.toCharArray();
                char[] chars2 = o2.toCharArray();
                for (int i = 0; i < chars1.length; i++) {
                    if (i >= chars2.length) return 1;
                    if (chars1[i] < chars2[i]) return -1;
                    if (chars1[i] > chars2[i]) return 1;
                }
                return chars1.length == chars2.length ? 0 : -1;
            }
        }, 0, arr.length - 1);
        /* 输出结果 */
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 使用归并排序，时间复杂度：O（nlogn），空间复杂度：O（n）
     * @param arr
     * @param comparator
     */
    public static void sortString(String[] arr, Comparator<String> comparator, int left, int right) {
        /* 递归结束条件 */
        if (right <= left) return;
        int mid = left + (right - left) / 2;
        /* 进行递归 */
        sortString(arr, comparator, left, mid);
        sortString(arr, comparator, mid + 1, right);
        /* 进行合并 */
        int l = left;
        int r = mid + 1;
        int index = 0;
        String[] tem = new String[right - left + 1];
        while (l <= mid && r <= right) {
            if (comparator.compare(arr[l], arr[r]) == 1) {
                tem[index++] = arr[r++];
            } else {
                tem[index++] = arr[l++];
            }
        }
        while (l <= mid) tem[index++] = arr[l++];
        while (r <= right) tem[index++] = arr[r++];
        index = 0;
        while (left <= right) arr[left++] = tem[index++];
    }

    //============================================= 成绩排序 ==============================================//
    /**
     * 给定一些同学的信息（名字，成绩）序列，请你将他们的信息按照成绩从高到低或从低到高的排列,相同成绩
     * 都按先录入排列在前的规则处理。
     * 题意：使用稳定排序
     */
    /**
     * 使用快速排序
     */
    public static void helper3() {
        /* 读取数据 */
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine()); // 字符串总数
        boolean asc = Integer.parseInt(scanner.nextLine()) != 0; // 排序方式，true：使用升序，false：使用降序
        String[][] arr = new String[total][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = scanner.next();
            arr[i][1] = scanner.next();
        }
        /* 进行排序 */
        sortStu(arr, new Comparator<String[]>() {
            /**
             * 比较两个学生成绩
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return 1：o1 > o2，0：o1 == o2，-1：o1 < o2
             */
            @Override
            public int compare(String[] o1, String[] o2) {
                /* 特殊情况 */
                if (o1 == null && o2 == null) return 0;
                if (o1 == null) return -1;
                if (o2 == null) return 1;
                int res = Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1]));
                return asc ? res : -res;
            }
        }, 0, arr.length - 1);
        /* 输出结果 */
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }

    /**
     * 使用 Java 内置排序算法
     */
    public static void helper4() {
        /* 读取数据 */
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine()); // 字符串总数
        boolean asc = Integer.parseInt(scanner.nextLine()) != 0; // 排序方式，true：使用升序，false：使用降序
        Stu[] arr = new Stu[total];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Stu(scanner.next(), Integer.parseInt(scanner.next()));
        }
        /* 进行排序 */
        Arrays.sort(arr, (Stu o1, Stu o2) -> {
            int compare = Integer.compare(o1.score, o2.score);
            return asc ? compare : -compare;
        });
        /* 输出结果 */
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static class Stu {
        String name;
        int score;
        public Stu(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return  name + " " + score;
        }
    }


    /**
     * 使用归并排序，时间复杂度：O（nlogn），空间复杂度：O（n）
     * @param arr
     * @param comparator
     */
    public static void sortStu(String[][] arr, Comparator<String[]> comparator, int left, int right) {
        /* 递归结束条件 */
        if (right <= left) return;
        int mid = left + (right - left) / 2;
        /* 进行递归 */
        sortStu(arr, comparator, left, mid);
        sortStu(arr, comparator, mid + 1, right);
        /* 进行合并 */
        int l = left;
        int r = mid + 1;
        int index = 0;
        String[][] tem = new String[right - left + 1][2];
        while (l <= mid && r <= right) {
            if (comparator.compare(arr[l], arr[r]) == 1) {
                tem[index++] = arr[r++];
            } else {
                tem[index++] = arr[l++];
            }
        }
        while (l <= mid) tem[index++] = arr[l++];
        while (r <= right) tem[index++] = arr[r++];
        index = 0;
        while (left <= right) arr[left++] = tem[index++];
    }

    //============================================== 合并区间 ==================================================
    /**
     * 给出一组区间，请合并所有重叠的区间。
     * 请保证合并后的区间按区间起点升序排列。
     */
    /**
     * 使用暴力法，时间复杂度：O（nlogn）
     * 将对象按照起始位置进行排序，然后进行合并
     * @param intervals
     * @return
     */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Interval[] arr = new Interval[intervals.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = intervals.get(i);
        }
        /* 进行排序 */
        sortInterval(arr, (Interval o1, Interval o2) -> {
            return Integer.compare(o1.start, o2.start);
        }, 0, arr.length - 1);
        /* 进行合并 */
        int index = 0;
        /* 获取结果 */
        ArrayList<Interval> list = new ArrayList<>();
        mergeOper(arr, list);
        return list;
    }

    /**
     * 对 Interval 集合进行排序
     * 使用并归
     * @param intervals
     * @param comparator
     * @param left
     * @param right
     */
    public void sortInterval(Interval[] intervals, Comparator<Interval> comparator, int left, int right) {
        /* 递归结束条件 */
        if (left >= right) return;
        /* 先进行递归 */
        int mid = left + (right - left) / 2;
        sortInterval(intervals, comparator, left, mid);
        sortInterval(intervals, comparator, mid + 1, right);
        /* 进行合并 */
        int l = left;
        int r = mid + 1;
        Interval[] tem = new Interval[right - left + 1];
        int index = 0;
        while (l <= mid && r <= right) {
            if (comparator.compare(intervals[l], intervals[r]) == 1) {
                tem[index++] = intervals[r++];
            } else {
                tem[index++] = intervals[l++];
            }
        }
        while (l <= mid) tem[index++] = intervals[l++];
        while (r <= right) tem[index++] = intervals[r++];
        index = 0;
        while (left <= right) intervals[left++] = tem[index++];
    }

    /**
     * 进行合并操作
     * @param intervals 待合并数组
     * @param list 合并后的 list 对象
     */
    public void mergeOper(Interval[] intervals, ArrayList<Interval> list) {
        int index = 0;
        while (index < intervals.length) {
            Interval tem = intervals[index];
            index++;
            while (index < intervals.length && tem.end >= intervals[index].start) tem.end = Math.max(intervals[index++].end, tem.end);
            list.add(tem);
        }
    }

    /**
     * 使用 HashMap 保存每一个区间的
     * 将对象按照起始位置进行排序，然后进行合并
     * @param intervals
     * @return
     */
    public ArrayList<Interval> merge2(ArrayList<Interval> intervals) {
        Interval[] arr = new Interval[intervals.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = intervals.get(i);
        }
        /* 进行排序 */
        sortInterval(arr, (Interval o1, Interval o2) -> {
            return Integer.compare(o1.start, o2.start);
        }, 0, arr.length - 1);
        /* 进行合并 */
        int index = 0;
        /* 获取结果 */
        ArrayList<Interval> list = new ArrayList<>();
        mergeOper(arr, list);
        return list;
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    //============================================ 括号的最大深度 ============================、

    /**
     * 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
     */
    /**
     * 使用类似与栈的方式获取最大嵌套深度
     * @param s 目标字符串
     * @return
     */
    public int maxDepth(String s) {
        /* 特殊情况 */
        if (s == null || s.length() == 0) return 0;
        /* 获取最大深度 */
        int res = 0;
        int count = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(')  count++;
            else if (c == ')') count--;
            res = Math.max(res, count);
        }
        return res;
    }


    //================================================ 有效括号序列 =============================================
    /**
     * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
     * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
     */
    /**
     * 使用栈来解决
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        /* 特殊情况处理 */
        if (s == null || s.length() == 0) return true;
        /* 判断字符串是否符合要求 */
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if (c == ')' && pop != '(') return false;
                if (c == ']' && pop != '[') return false;
                if (c == '}' && pop != '{') return false;
            }
        }
        /* 需要考虑最后是否仍然有字符没有匹配的情况 */
        return stack.isEmpty();
    }



    public static void main(String[] args) {
    }

}
