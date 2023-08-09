package month08;

/**
 * ʱ�䣺2023/8/9
 * ������������������������ϲ�Ϊһ���µ� ���� �������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�
 * �����/���˼·��ʹ��˫ָ��
 * ���룺��ƫ��
 */
public class Day09_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /* ����������� */
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        /* ʹ��˫ָ�뿪ʼ���кϲ� */
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