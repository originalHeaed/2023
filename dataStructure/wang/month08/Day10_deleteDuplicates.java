package month08;

import java.util.List;
import java.util.logging.Level;

/**
 * 时间：2023/8/10
 * 问题描述：
 *  给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 切入点/解决思路：使用双指针
 * 感想：中等
 */
public class Day10_deleteDuplicates {
    /**
     * 时间复杂度：O（n），空间复杂度：O（n）
     */
    public ListNode deleteDuplicates(ListNode head) {
        /* 特殊情况处理 */
        if (head == null || head.next == null) return head;
        /* 开始去重 */
        ListNode guard = new ListNode(); // 哨兵节点
        ListNode left = guard; // 用来指向最后一个不含重复元素的节点
        ListNode right = head; // 用来寻找下一个没有重复元素的节点
        while (right != null) {
            if (right.next == null || right.next.val != right.val) {
                /* 如果 right 是最后一个节点或 right 与 right 下一个节点的值不一致，则需要将当前 right 加入到结果中 */
                left.next = right;
                right = right.next;
                left = left.next;
                left.next = null;
            } else {
                /* right 非最后一个节点，且 right 与 right 下一个节点的值一样，则需要跳过这整个部分 */
                int val = right.val;
                while (right != null && right.val == val) right = right.next;
            }
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