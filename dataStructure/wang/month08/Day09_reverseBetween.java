package month08;

import java.util.List;

/**
 * 时间：2023/8/9
 * 问题描述：
 *  给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 *  请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 切入点/解决思路：双指针，使用尾插法，需要用到头结点
 * 感想：中等
 */
public class Day09_reverseBetween {
    /**
     * 时间复杂度：O（n），空间复杂度：O（1）
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /* 特殊情况处理 */
        if (head == null || left == right) return head;
        /* 将两个指针移动到指定的位置 */
        ListNode guard = new ListNode();
        guard.next = head;
        ListNode leftNode = guard; // 需要走到第一个待反转节点的前面
        ListNode rightNode = guard; // 最后一个需要反转的节点
        for (int i = 1; i < left; i++) {
            leftNode = leftNode.next;
        }
        for (int i = 1; i <= right; i++) {
            rightNode = rightNode.next;
        }
        /* 不断的将 leftNode.next 指向的节点移动到 rightNode.next 中，需要移动 right - left 次 */
        int total = right - left;
        while (total > 0) {
            ListNode tem = leftNode.next.next;
            leftNode.next.next = rightNode.next;
            rightNode.next = leftNode.next;
            leftNode.next = tem;
            total--;
        }
        return guard.next;
    }
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

}