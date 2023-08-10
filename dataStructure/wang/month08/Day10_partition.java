package month08;

/**
 * 时间：2023/8/10
 * 问题描述：
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 切入点/解决思路：使用双指针
 * 感想：中等偏下
 */
public class Day10_partition {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 时间复杂度：O（n），空间复杂度：O（n）
     */
    public ListNode partition(ListNode head, int x) {
        /* 特殊情况处理 */
        if (head == null || head.next == null) return head;
        /* 开始处理 */
        ListNode guard = new ListNode(); // 哨兵节点
        guard.next = head;
        ListNode left = guard; // 用来指向最后一个小于 x 的节点
        ListNode right = guard; // 寻找下一个小于 x 的节点
        while (right.next != null) {
            if (right.next.val >= x) right = right.next;
            else if (right == left) {
                left = left.next;
                right = right.next;
            } else {
                ListNode node = right.next;
                right.next = right.next.next;
                node.next = left.next;
                left.next = node;
                left = left.next;
            }
        }
        return guard.next;
    }
}