package month08;

/**
 * ʱ�䣺2023/8/10
 * ����������
 * ����һ�������ͷ�ڵ� head ��һ���ض�ֵ x �������������зָ���ʹ������ С�� x �Ľڵ㶼������ ���ڻ���� x �Ľڵ�֮ǰ��
 * ��Ӧ�� ���� ����������ÿ���ڵ�ĳ�ʼ���λ�á�
 * �����/���˼·��ʹ��˫ָ��
 * ���룺�е�ƫ��
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
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��n��
     */
    public ListNode partition(ListNode head, int x) {
        /* ����������� */
        if (head == null || head.next == null) return head;
        /* ��ʼ���� */
        ListNode guard = new ListNode(); // �ڱ��ڵ�
        guard.next = head;
        ListNode left = guard; // ����ָ�����һ��С�� x �Ľڵ�
        ListNode right = guard; // Ѱ����һ��С�� x �Ľڵ�
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