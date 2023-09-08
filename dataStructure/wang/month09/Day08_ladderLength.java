package month09;

import java.util.*;

/**
 * 时间：2023/9/8
 * 问题描述：
 *  字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 *  每一对相邻的单词只差一个字母。
 *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。sk == endWord
 *  给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 * 切入点/解决思路：建立一个又向图，然是使用广度优先搜索
 * 感想：中等
 */
public class Day08_ladderLength {
    /**
     * 时间复杂度：O（n^2）
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /* 特殊情况处理 */
        if (beginWord == endWord || beginWord.equals(endWord)) return 0;
        if (wordList == null || wordList.size() == 0) return 0;
        /* 进行广度优先搜索 */
        Set<String> container = new HashSet<>(); // 图（没有连接，需要自行寻找所有相邻节点）
        Queue<String> queue = new LinkedList<>(); // 进行广度优先搜索
        int count = 1;
        for (int i = 0; i < wordList.size(); i++) {
            container.add(wordList.get(i));
        }
        container.add(beginWord);
        if (!container.contains(endWord)) return 0;
        queue.add(beginWord);
        container.remove(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String val = queue.poll();
                if (val.equals(endWord)) return count;
                List<String> needRemove = new LinkedList<>();
                /* 从图中将所有为访问过的且与 val 相差一个字符的 字符串 加入到队列中 */
                container.forEach(ele -> {
                    if (isApproximate(val, ele)) {
                        queue.add(ele);
                        needRemove.add(ele);
                    }
                });
                needRemove.forEach(ele -> container.remove(ele));
            }
            count++;
        }
        return 0;
    }

    /**
     * 判断 val1 和 val2 是否相差一个字符
     */
    private boolean isApproximate(String val1, String val2) {
        if (val1 == val2 || val1.equals(val2)) return false;
        if (val1.length() != val2.length()) return false;
        int diff = 0;
        for (int i = 0; i < val1.length(); i++) {
            if (val1.charAt(i) != val2.charAt(i)) {
                diff++;
                if (diff == 2) return false;
            }
        }
        return true;
    }
}