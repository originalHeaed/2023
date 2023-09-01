package month09;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 时间：2023/9/1
 * 问题描述：
 *  现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *  例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 *  返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * 切入点/解决思路：使用拓扑排序
 * 感想：中等
 */
public class Day01_findOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /* 特殊情况处理 */
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return new int[0];
        /* 构建有向图 */
        List<List<Integer>> map = new ArrayList<>();
        int[] in = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map.add(new LinkedList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }
        /* 使用拓扑排序，来获取任意一种可能的排序 */
        int count = 0;
        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            /* 遍历所有入度为 0 的节点 */
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                res[count++] = poll;
                /* 将所有入度为 0 的节点指向的节点入度减一 */
                map.get(poll).stream().forEach(index -> {
                    in[index]--;
                    if (in[index] == 0) queue.add(index);
                });
            }
        }
        return count == numCourses ? res : new int[0];
    }

}