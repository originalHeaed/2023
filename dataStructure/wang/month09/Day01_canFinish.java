package month09;

import java.util.*;

/**
 * 时间：2023/9/1
 * 问题描述：
 *  你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *  在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *  例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 *  请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 切入点/解决思路：使用有向图的拓扑排序方法，根据节点的入度值来判断是否存在环
 *  在一个有向图中，如果这个有向图中无环则从入度为 0 的节点开始依次将各个相关节点的入度减少，最终所有节点的入度都会为 0，如果所有的节点入度都不为 0 则表示这些节点是环上的一部分
 * 感想：中等
 */
public class Day01_canFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /* 特殊情况考虑 */
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
        List<List<Integer>> map = new ArrayList<>();
        int[] in = new int[numCourses]; // 保存每个节点的入度值
        /* 构造有向图 */
        for (int i = 0; i < numCourses; i++) {
            map.add(new LinkedList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            in[prerequisites[i][0]]++; // 节点入度加一
        }
        /* 找到所有入度为 0 的节点 */
        int count  = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                count++;
                map.get(poll).stream().forEach(index -> {
                    in[index]--;
                    if (in[index] == 0) queue.add(index);
                });
            }
        }
        return count == numCourses;
    }
}