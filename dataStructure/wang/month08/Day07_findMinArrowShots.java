package month08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 时间：2023/8/7
 * 问题描述：
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
 * 其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * 切入点/解决思路：先排序 + 贪心，取交集
 * 感想：中等
 */
public class Day07_findMinArrowShots {
    /**
     * 时间复杂度：O（nlogn），空间复杂度：O（n）
     */
    public int findMinArrowShots(int[][] points) {
        /* 特殊情况处理 */
        if (points == null) return 0;
        /* 获取元素之间交易 */
        Arrays.sort(points, Comparator.comparingInt(val -> val[0])); // 按每个气球左边的值进行升序排序
        int total = 1;
        int left = points[0][0];
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            /* 根据上一个交集的边界，计算当前气球能否在上一个交集中被引爆 */
            if (points[i][0] > right) {
                /* 不能，则重置交集范围 */
                left = points[i][0];
                right = points[i][1];
                total++;
            } else {
                /* 可以，则更新交集范围 */
                left = Math.max(left, points[i][0]);
                right = Math.min(right, points[i][1]);
            }
        }
        return total;
    }
}