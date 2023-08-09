package month08;

import java.util.List;

/**
 * ʱ�䣺2023/8/9
 * ����������
 *  ���㵥�����ͷָ�� head ���������� left �� right ������ left <= right ��
 *  ���㷴ת��λ�� left ��λ�� right ������ڵ㣬���� ��ת������� ��
 * �����/���˼·��˫ָ�룬ʹ��β�巨����Ҫ�õ�ͷ���
 * ���룺�е�
 */
public class Day09_reverseBetween {
    /**
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��1��
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /* ����������� */
        if (head == null || left == right) return head;
        /* ������ָ���ƶ���ָ����λ�� */
        ListNode guard = new ListNode();
        guard.next = head;
        ListNode leftNode = guard; // ��Ҫ�ߵ���һ������ת�ڵ��ǰ��
        ListNode rightNode = guard; // ���һ����Ҫ��ת�Ľڵ�
        for (int i = 1; i < left; i++) {
            leftNode = leftNode.next;
        }
        for (int i = 1; i <= right; i++) {
            rightNode = rightNode.next;
        }
        /* ���ϵĽ� leftNode.next ָ��Ľڵ��ƶ��� rightNode.next �У���Ҫ�ƶ� right - left �� */
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