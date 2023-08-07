package month08;

/**
 * 时间：2023/8/7
 * 问题描述：
 *  给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *  在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 切入点/解决思路：直接插入即可，有点类似于滑动窗口
 * 感想：中等偏下
 */
public class Day07_insert {
    /**
     * 时间复杂度：O（n），空间复杂度：O（n）
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /* 特殊情况处理 */
        if (intervals == null || newInterval == null) return intervals;
        /* 开始插入 */
        int[][] temIntervals = new int[intervals.length + 1][2];
        int base = 0;
        int i = 0;
        while (i < intervals.length) {
            if (intervals[i][0] > newInterval[1]) {
                /* 无需合并，且新区间在第 i 个区间左边 */
                temIntervals[base][0] = newInterval[0];
                temIntervals[base][1] = newInterval[1];
                base++;
                break;
            } else if (intervals[i][1] < newInterval[0]) {
                /* 无需合并，且新区间在第 i 个区间右边 */
                temIntervals[base][0] = intervals[i][0];
                temIntervals[base][1] = intervals[i][1];
                base++;
                i++;
            } else {
                /* 需要合并，将新区间与第 i 个区间合并，形成新的新区间 */
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
        }
        if (i == intervals.length) {
            temIntervals[base][0] = newInterval[0];
            temIntervals[base][1] = newInterval[1];
            base++;
        } else {
            for (; i < intervals.length; i++, base++) {
                temIntervals[base][0] = intervals[i][0];
                temIntervals[base][1] = intervals[i][1];
            }
        }
        /* 将数组进行裁剪，去掉值为空的部分 */
        int[][] res = new int[base][2];
        for (int j = 0; j < res.length; j++) {
            res[j][0] = temIntervals[j][0];
            res[j][1] = temIntervals[j][1];
        }
        return res;
    }
}