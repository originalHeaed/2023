package month08;

/**
 * 时间：2023/8/7
 * 问题描述：
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 切入点/解决思路：使用并查集
 * 感想：中等偏上
 */
public class Day07_merge {
    /**
     * 时间复杂度：O（n^2），空间复杂度：O（1）
     */
    public int[][] merge(int[][] intervals) {
        /* 特殊情况处理 */
        if (intervals == null || intervals.length <= 1) return intervals;
        /* 开始合并 */
        Node head = new Node(-1, -1);
        Node tem;
        int total = 0;
        for (int i = 0; i < intervals.length; i++) {
            Node node = new Node(intervals[i][0], intervals[i][1]);
            tem = head;
            while (true) {
                /* 当前节点是最后一个节点 */
                if (tem.next == null) {
                    tem.next = node;
                    total++;
                    break;
                }
                if (tem.next.left > node.right){
                    /* 待加入节点的范围在下一个节点的范围前面，将该节点插入到这个位置 */
                    node.next = tem.next;
                    tem.next = node;
                    total++;
                    break;
                } else if (tem.next.right < node.left){
                    /* 移动到下一个节点 */
                    tem = tem.next;
                } else {
                    /* 待加入的节点与下一个节点重合，则更新待加入节点信息且删除下一个节点 */
                    node.left = Math.min(node.left, tem.next.left);
                    node.right = Math.max(node.right, tem.next.right);
                    tem.next = tem.next.next;
                    total--;
                }
            }
        }
        /* 获取最后的数据 */
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