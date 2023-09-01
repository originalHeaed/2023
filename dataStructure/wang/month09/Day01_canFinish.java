package month09;

import java.util.*;

/**
 * ʱ�䣺2023/9/1
 * ����������
 *  �����ѧ�ڱ���ѡ�� numCourses �ſγ̣���Ϊ 0 �� numCourses - 1 ��
 *  ��ѡ��ĳЩ�γ�֮ǰ��ҪһЩ���޿γ̡� ���޿γ̰����� prerequisites ���������� prerequisites[i] = [ai, bi] ����ʾ���Ҫѧϰ�γ� ai �� ���� ��ѧϰ�γ�  bi ��
 *  ���磬���޿γ̶� [0, 1] ��ʾ����Ҫѧϰ�γ� 0 ������Ҫ����ɿγ� 1 ��
 *  �����ж��Ƿ����������пγ̵�ѧϰ��������ԣ����� true �����򣬷��� false ��
 * �����/���˼·��ʹ������ͼ���������򷽷������ݽڵ�����ֵ���ж��Ƿ���ڻ�
 *  ��һ������ͼ�У�����������ͼ���޻�������Ϊ 0 �Ľڵ㿪ʼ���ν�������ؽڵ����ȼ��٣��������нڵ����ȶ���Ϊ 0��������еĽڵ���ȶ���Ϊ 0 ���ʾ��Щ�ڵ��ǻ��ϵ�һ����
 * ���룺�е�
 */
public class Day01_canFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /* ����������� */
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
        List<List<Integer>> map = new ArrayList<>();
        int[] in = new int[numCourses]; // ����ÿ���ڵ�����ֵ
        /* ��������ͼ */
        for (int i = 0; i < numCourses; i++) {
            map.add(new LinkedList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            in[prerequisites[i][0]]++; // �ڵ���ȼ�һ
        }
        /* �ҵ��������Ϊ 0 �Ľڵ� */
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