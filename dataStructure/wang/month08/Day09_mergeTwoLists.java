package month08;

/**
 * 时间：2023/8/9
 * 问题描述：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 切入点/解决思路：使用双指针
 * 感想：简单偏上
 */
public class Day09_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /* 特殊情况处理 */
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        /* 使用双指针开始进行合并 */
        ListNode head = new ListNode();
        ListNode tem = head;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tem.next = list2;
                list2 = list2.next;
            } else {
                tem.next = list1;
                list1 = list1.next;
            }
            tem = tem.next;
        }
        if (list1 == null) tem.next = list2;
        else tem.next = list1;
        return head.next;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

}