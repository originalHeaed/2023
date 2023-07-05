package month7;

/**
 * 时间：2023/7/5
 * 问题描述：袋子中装有一些物品，每个物品上都标记着数字 1 、0 或 -1 。给你四个非负整数 numOnes 、numZeros 、numNegOnes 和 k 。
 *      现计划从这些物品中恰好选出 k 件物品。返回所有可行方案中，物品上所标记数字之和的最大值。
 * 切入点/解决思路：贪心（每次都选最大的）
 * 感想：
 */
public class Day05_kItemsWithMaximumSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) return k;
        if (k <= (numOnes + numZeros)) return numOnes;
        return numOnes - (k - numOnes - numZeros);
    }
}