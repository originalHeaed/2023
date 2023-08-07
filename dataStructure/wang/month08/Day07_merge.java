package month08;

/**
 * ʱ�䣺2023/8/7
 * ����������
 * ������ intervals ��ʾ���ɸ�����ļ��ϣ����е�������Ϊ intervals[i] = [starti, endi] ��
 * ����ϲ������ص������䣬������ һ�����ص����������飬��������ǡ�ø��������е��������� ��
 * �����/���˼·��ʹ�ò��鼯
 * ���룺�е�ƫ��
 */
public class Day07_merge {
    /**
     * ʱ�临�Ӷȣ�O��n^2�����ռ临�Ӷȣ�O��1��
     */
    public int[][] merge(int[][] intervals) {
        /* ����������� */
        if (intervals == null || intervals.length <= 1) return intervals;
        /* ��ʼ�ϲ� */
        Node head = new Node(-1, -1);
        Node tem;
        int total = 0;
        for (int i = 0; i < intervals.length; i++) {
            Node node = new Node(intervals[i][0], intervals[i][1]);
            tem = head;
            while (true) {
                /* ��ǰ�ڵ������һ���ڵ� */
                if (tem.next == null) {
                    tem.next = node;
                    total++;
                    break;
                }
                if (tem.next.left > node.right){
                    /* ������ڵ�ķ�Χ����һ���ڵ�ķ�Χǰ�棬���ýڵ���뵽���λ�� */
                    node.next = tem.next;
                    tem.next = node;
                    total++;
                    break;
                } else if (tem.next.right < node.left){
                    /* �ƶ�����һ���ڵ� */
                    tem = tem.next;
                } else {
                    /* ������Ľڵ�����һ���ڵ��غϣ�����´�����ڵ���Ϣ��ɾ����һ���ڵ� */
                    node.left = Math.min(node.left, tem.next.left);
                    node.right = Math.max(node.right, tem.next.right);
                    tem.next = tem.next.next;
                    total--;
                }
            }
        }
        /* ��ȡ�������� */
        int[][] res = new int[total][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = head.next.left;
            res[i][1] = head.next.right;
            head = head.next;
        }
        return res;
    }

    class Node {
        int left;
        int right;
        Node next;
        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

}