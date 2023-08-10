package month08;

import java.util.List;
import java.util.logging.Level;

/**
 * ʱ�䣺2023/8/10
 * ����������
 *  ����һ��������������ͷ head �� ɾ��ԭʼ�����������ظ����ֵĽڵ㣬ֻ���²�ͬ������ ������ ����������� ��
 * �����/���˼·��ʹ��˫ָ��
 * ���룺�е�
 */
public class Day10_deleteDuplicates {
    /**
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��n��
     */
    public ListNode deleteDuplicates(ListNode head) {
        /* ����������� */
        if (head == null || head.next == null) return head;
        /* ��ʼȥ�� */
        ListNode guard = new ListNode(); // �ڱ��ڵ�
        ListNode left = guard; // ����ָ�����һ�������ظ�Ԫ�صĽڵ�
        ListNode right = head; // ����Ѱ����һ��û���ظ�Ԫ�صĽڵ�
        while (right != null) {
            if (right.next == null || right.next.val != right.val) {
                /* ��� right �����һ���ڵ�� right �� right ��һ���ڵ��ֵ��һ�£�����Ҫ����ǰ right ���뵽����� */
                left.next = right;
                right = right.next;
                left = left.next;
                left.next = null;
            } else {
                /* right �����һ���ڵ㣬�� right �� right ��һ���ڵ��ֵһ��������Ҫ�������������� */
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