package month09;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ʱ�䣺2023/9/1
 * ����������
 *  �������ܹ��� numCourses �ſ���Ҫѡ����Ϊ 0 �� numCourses - 1������һ������ prerequisites ������ prerequisites[i] = [ai, bi] ����ʾ��ѡ�޿γ� ai ǰ ���� ��ѡ�� bi ��
 *  ���磬��Ҫѧϰ�γ� 0 ������Ҫ����ɿγ� 1 ��������һ��ƥ������ʾ��[0,1] ��
 *  ������Ϊ��ѧ�����пγ������ŵ�ѧϰ˳�򡣿��ܻ��ж����ȷ��˳����ֻҪ���� ����һ�� �Ϳ����ˡ����������������пγ̣����� һ�������� ��
 * �����/���˼·��ʹ����������
 * ���룺�е�
 */
public class Day01_findOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /* ����������� */
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return new int[0];
        /* ��������ͼ */
        List<List<Integer>> map = new ArrayList<>();
        int[] in = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map.add(new LinkedList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }
        /* ʹ��������������ȡ����һ�ֿ��ܵ����� */
        int count = 0;
        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            /* �����������Ϊ 0 �Ľڵ� */
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                res[count++] = poll;
                /* ���������Ϊ 0 �Ľڵ�ָ��Ľڵ���ȼ�һ */
                map.get(poll).stream().forEach(index -> {
                    in[index]--;
                    if (in[index] == 0) queue.add(index);
                });
            }
        }
        return count == numCourses ? res : new int[0];
    }

}