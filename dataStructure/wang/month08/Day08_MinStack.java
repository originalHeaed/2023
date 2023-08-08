package month08;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2023/8/8
 * 问题描述：
 *  设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *  实现 MinStack 类:
 *      MinStack() 初始化堆栈对象。
 *      void push(int val) 将元素val推入堆栈。
 *      void pop() 删除堆栈顶部的元素。
 *      int top() 获取堆栈顶部的元素。
 *      int getMin() 获取堆栈中的最小元素。
 * 切入点/解决思路：使用两个数组，一个用来当做栈，一个用来当做最小堆
 * 感想：中等
 */
public class Day08_MinStack {
    /**
     * 作为栈使用
     */
    List<Integer> stack;

    /**
     * 作为最小堆使用
     */
    List<Integer> minHeap;

    /**
     * 当前容器内元素总数量
     */
    int total;

    public void MinStack() {
        stack = new ArrayList<>(15000); // 最多被调用 30000 次
        minHeap = new ArrayList<>(15000); // 第一个元素不用
        minHeap.add(-1); // 将下标为 0 的元素去掉，不用，方便后续计算
        total = 0;
    }

    /**
     * 时间复杂度：O（logn）
     */
    public void push(int val) {
        total++;
        stack.add(val);
        minHeap.add(val);
        /* 将元素加入到最小堆中，并进行自下而上的调整 */
        int tem = total;
        while (tem > 1) {
            /* 判断父节点是否需要和子节点进行交换（只针对这一个子节点） */
            int parentIndex = tem / 2;
            int parentVal = minHeap.get(parentIndex);
            int childVal = minHeap.get(tem);
            if (parentVal > childVal) {
                minHeap.set(parentIndex, childVal);
                minHeap.set(tem, parentVal);
            } else {
                /* 已经调整完毕 */
                break;
            }
            tem = parentIndex;
        }
    }

    /**
     * 时间复杂度：O（n）
     */
    public void pop() {
        int target = stack.get(total - 1);
        /* 调整堆，自上而下 */
        int i = 1;
        /* 找到需要删除元素在堆中的下标，并将堆中最后一个元素替换到该位置 */
        for (; i < minHeap.size(); i++) {
            if (minHeap.get(i) == target) break;
        }
        int lastVal = minHeap.get(total);
        minHeap.set(i, lastVal);
        minHeap.remove(total);
        /* 从该位置开始进行自上而下的调整 */
        total--;
        stack.remove(total);
        while (i < total) {
            /* 找到该节点左右子节点最小值 */
            int leftIndex = i * 2;
            int rightIndex = i * 2 + 1;
            int minIndex = 0;
            if (leftIndex >= minHeap.size()) break;
            else if (rightIndex < minHeap.size() && minHeap.get(rightIndex) < minHeap.get(leftIndex)) minIndex = rightIndex;
            else minIndex = leftIndex;
            /* 判断是否需要调整 */
            if (minHeap.get(i) > minHeap.get(minIndex)) {
                int parentVal = minHeap.get(i);
                int childVal = minHeap.get(minIndex);
                minHeap.set(i, childVal);
                minHeap.set(minIndex, parentVal);
            } else {
                /* 后面的就不需要再进行调整了 */
                break;
            }
            i = minIndex;
        }
    }

    /**
     * 时间复杂度：O（1）
     */
    public int top() {
        return stack.get(total - 1);
    }

    /**
     * 时间复杂度：O（1）
     */
    public int getMin() {
        return minHeap.get(1);
    }

    public static void main(String[] args) {
        Day08_MinStack minStack = new Day08_MinStack();
        minStack.MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.pop();
        minStack.pop();
    }
}