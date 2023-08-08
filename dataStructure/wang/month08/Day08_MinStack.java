package month08;

import java.util.ArrayList;
import java.util.List;

/**
 * ʱ�䣺2023/8/8
 * ����������
 *  ���һ��֧�� push ��pop ��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��
 *  ʵ�� MinStack ��:
 *      MinStack() ��ʼ����ջ����
 *      void push(int val) ��Ԫ��val�����ջ��
 *      void pop() ɾ����ջ������Ԫ�ء�
 *      int top() ��ȡ��ջ������Ԫ�ء�
 *      int getMin() ��ȡ��ջ�е���СԪ�ء�
 * �����/���˼·��ʹ���������飬һ����������ջ��һ������������С��
 * ���룺�е�
 */
public class Day08_MinStack {
    /**
     * ��Ϊջʹ��
     */
    List<Integer> stack;

    /**
     * ��Ϊ��С��ʹ��
     */
    List<Integer> minHeap;

    /**
     * ��ǰ������Ԫ��������
     */
    int total;

    public void MinStack() {
        stack = new ArrayList<>(15000); // ��౻���� 30000 ��
        minHeap = new ArrayList<>(15000); // ��һ��Ԫ�ز���
        minHeap.add(-1); // ���±�Ϊ 0 ��Ԫ��ȥ�������ã������������
        total = 0;
    }

    /**
     * ʱ�临�Ӷȣ�O��logn��
     */
    public void push(int val) {
        total++;
        stack.add(val);
        minHeap.add(val);
        /* ��Ԫ�ؼ��뵽��С���У����������¶��ϵĵ��� */
        int tem = total;
        while (tem > 1) {
            /* �жϸ��ڵ��Ƿ���Ҫ���ӽڵ���н�����ֻ�����һ���ӽڵ㣩 */
            int parentIndex = tem / 2;
            int parentVal = minHeap.get(parentIndex);
            int childVal = minHeap.get(tem);
            if (parentVal > childVal) {
                minHeap.set(parentIndex, childVal);
                minHeap.set(tem, parentVal);
            } else {
                /* �Ѿ�������� */
                break;
            }
            tem = parentIndex;
        }
    }

    /**
     * ʱ�临�Ӷȣ�O��n��
     */
    public void pop() {
        int target = stack.get(total - 1);
        /* �����ѣ����϶��� */
        int i = 1;
        /* �ҵ���Ҫɾ��Ԫ���ڶ��е��±꣬�����������һ��Ԫ���滻����λ�� */
        for (; i < minHeap.size(); i++) {
            if (minHeap.get(i) == target) break;
        }
        int lastVal = minHeap.get(total);
        minHeap.set(i, lastVal);
        minHeap.remove(total);
        /* �Ӹ�λ�ÿ�ʼ�������϶��µĵ��� */
        total--;
        stack.remove(total);
        while (i < total) {
            /* �ҵ��ýڵ������ӽڵ���Сֵ */
            int leftIndex = i * 2;
            int rightIndex = i * 2 + 1;
            int minIndex = 0;
            if (leftIndex >= minHeap.size()) break;
            else if (rightIndex < minHeap.size() && minHeap.get(rightIndex) < minHeap.get(leftIndex)) minIndex = rightIndex;
            else minIndex = leftIndex;
            /* �ж��Ƿ���Ҫ���� */
            if (minHeap.get(i) > minHeap.get(minIndex)) {
                int parentVal = minHeap.get(i);
                int childVal = minHeap.get(minIndex);
                minHeap.set(i, childVal);
                minHeap.set(minIndex, parentVal);
            } else {
                /* ����ľͲ���Ҫ�ٽ��е����� */
                break;
            }
            i = minIndex;
        }
    }

    /**
     * ʱ�临�Ӷȣ�O��1��
     */
    public int top() {
        return stack.get(total - 1);
    }

    /**
     * ʱ�临�Ӷȣ�O��1��
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