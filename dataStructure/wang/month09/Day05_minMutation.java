package month09;

import java.util.*;

/**
 * 时间：2023/9/5
 * 问题描述：
 *  基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 *  假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 *  例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 *  另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 *  给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 *  注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 * 切入点/解决思路：
 * 感想：中等
 */
public class Day05_minMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>();
        /* 特殊情况处理 */
        if (startGene == null || endGene == null || startGene.length() != endGene.length() || bank.length == 0) return -1;
        Arrays.stream(bank).forEach(ele -> set.add(ele));
        if (!set.contains(endGene)) return -1;
        /* 进行广度优先搜索 */
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
     * 获取由 start 的所有可能
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