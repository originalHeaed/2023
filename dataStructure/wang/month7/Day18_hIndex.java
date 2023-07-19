package month7;

import java.util.Arrays;

/**
 * 时间：2023/7/18
 * 问题描述：给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h指数。
 *         根据维基百科上h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。
 *         如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * 切入点/解决思路：使用额外数组记录次数
 * 感想：有点意思
 */
public class Day18_hIndex {
    /**
     * 时间复杂度：O（1000n）
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        /* 特殊情况处理 */
        if (citations == null || citations.length == 0) return 0;
        // 下标表示文章数量，值表示当文章数量为 i 时，引用次数大于等于 i 的文章总数，
        // 为什么使用 1000，因为每篇文章最高的引用次数为 1000，也就是说 h 值最高也就是 1000，多的没必要统计
        // 为什么 + 1，方便后面计算，i 可以直接代表文章数量
        int[] count = new int[1000 + 1];
        for (int i = 0; i < citations.length; i++) {
            for (int j = 0; j <= citations[i]; j++) {
                count[j]++;
            }
        }
        /* 获取最大的 h 值 */
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] >= i) return i;
        }
        return 0;
    }

    /**
     * 时间复杂度：O（nlogn）
     * 使用排序算法
     */
    public int hIndex2(int[] citations) {
        /* 特殊情况处理 */
        if (citations == null || citations.length == 0) return 0;
        /* 排序，然后统计 */
        Arrays.sort(citations); // 排序之后为升序
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if(citations[i] > count) count++;
            else break;
        }
        return count;
    }

    /**
     * 时间复杂度：O（n + m） n - 数组的最大值，m - 出现最多的次数
     * 使用排序算法
     */
    public int hIndex3(int[] citations) {
        /* 特殊情况处理 */
        if (citations == null || citations.length == 0) return 0;
        /* 统计每种发布次数的文章数量 */
        int[] helper = new int[1001]; // 以空间换时间，避免排序
        for (int i = 0; i < citations.length; i++) {
            helper[citations[i]]++;
        }
        int count = 0;
        int index = helper.length - 1;
        while (index >= 0 && count < helper.length) {
            while (helper[index] > 0 && index > count){
                count++;
                helper[index]--;
            }
            index--;
        }
        return count;
    }


}