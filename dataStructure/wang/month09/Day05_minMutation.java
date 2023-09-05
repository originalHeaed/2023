package month09;

import java.util.*;

/**
 * ʱ�䣺2023/9/5
 * ����������
 *  �������п��Ա�ʾΪһ���� 8 ���ַ���ɵ��ַ���������ÿ���ַ����� 'A'��'C'��'G' �� 'T' ֮һ��
 *  ����������Ҫ����ӻ������� start ��Ϊ end �������Ļ���仯��һ�λ���仯����ζ��������������е�һ���ַ������˱仯��
 *  ���磬"AACCGGTT" --> "AACCGGTA" ����һ�λ���仯��
 *  ����һ������� bank ��¼��������Ч�Ļ���仯��ֻ�л�����еĻ��������Ч�Ļ������С����仯��Ļ������λ�ڻ���� bank �У�
 *  ���������������� start �� end ���Լ�һ������� bank �������ҳ��������ܹ�ʹ start �仯Ϊ end ��������ٱ仯����������޷���ɴ˻���仯������ -1 ��
 *  ע�⣺��ʼ�������� start Ĭ������Ч�ģ�����������һ��������ڻ�����С�
 * �����/���˼·��
 * ���룺�е�
 */
public class Day05_minMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>();
        /* ����������� */
        if (startGene == null || endGene == null || startGene.length() != endGene.length() || bank.length == 0) return -1;
        Arrays.stream(bank).forEach(ele -> set.add(ele));
        if (!set.contains(endGene)) return -1;
        /* ���й���������� */
        Queue<String> queue = new LinkedList<>();
        Set<String> hasVisit = new HashSet<>();
        queue.add(startGene);
        hasVisit.add(startGene);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(endGene)) return res;
                List<String> diff = getDiff(poll);
                diff.stream().forEach(ele -> {
                    if (set.contains(ele) && !hasVisit.contains(ele)) {
                        hasVisit.add(ele);
                        queue.add(ele);
                    }
                });
            }
            res++;
        }
        return -1;
    }

    /**
     * ��ȡ�� start �����п���
     */
    private List<String> getDiff(String start) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < start.length(); i++) {
            switch (start.charAt(i)) {
                case 'A':
                    res.add(start.substring(0, i) + 'C' + start.substring(i + 1));
                    res.add(start.substring(0, i) + 'G' + start.substring(i + 1));
                    res.add(start.substring(0, i) + 'T' + start.substring(i + 1));
                    break;
                case 'C':
                    res.add(start.substring(0, i) + 'A' + start.substring(i + 1));
                    res.add(start.substring(0, i) + 'G' + start.substring(i + 1));
                    res.add(start.substring(0, i) + 'T' + start.substring(i + 1));
                    break;
                case 'G':
                    res.add(start.substring(0, i) + 'A' + start.substring(i + 1));
                    res.add(start.substring(0, i) + 'C' + start.substring(i + 1));
                    res.add(start.substring(0, i) + 'T' + start.substring(i + 1));
                    break;
                case 'T':
                    res.add(start.substring(0, i) + 'A' + start.substring(i + 1));
                    res.add(start.substring(0, i) + 'C' + start.substring(i + 1));
                    res.add(start.substring(0, i) + 'G' + start.substring(i + 1));
                    break;
            }
        }
        return res;
    }

}