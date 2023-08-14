package month08;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * ʱ�䣺2023/8/14
 * ����������
 *  ���һ�� LRU ��ʵ��
 * �����/���˼·��ʹ�� map + ˫������
 * ���룺�е�ƫ��
 */
public class Day14_LRUCache {
    class Node {
        Node pre;
        Node next;
        int key;
        int val;
        public Node(int key, int val) {this.key = key;this.val = val;}
    }

    /**
     * �Զ���˫�˶���
     */
    class WghDList {
        /**
         * ˫�������ͷָ��
         */
        Node head;

        /**
         * ˫�������βָ��
         */
        Node tail;

        int amount;

        public WghDList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            amount = 0;
            head.next = tail;
            tail.pre = head;
        }

        /**
         * �Ƴ�ͷ��Ԫ��
         */
        public Node removeHead() {
            if (amount == 0) return null;
            amount--;
            return removeNode(head.next);
        }

        /**
         * �Ƴ�ָ��Ԫ��
         */
        public Node removeNode(Node node) {
            if (node == null) return null;
            node.next.pre = node.pre;
            node.pre.next = node.next;
            return node;
        }

        /**
         * �Ƴ�β��Ԫ��
         */
        public Node removeTail() {
            if (amount == 0) return null;
            amount--;
            return removeNode(tail.pre);
        }

        /**
         * ���ڵ���뵽˫������β��
         */
        public void addTail(Node node) {
            amount++;
            node.next = tail;
            node.pre = tail.pre;
            tail.pre.next = node;
            tail.pre = node;
        }
    }


    /**
     * �����洢��ֵ���Լ������ҵ��͸���ֵ
     */
    Map<Integer, Node> map;

    /**
     * ˫������
     */
    WghDList dequqeue;

    int total; // �����������������Ԫ���ܸ���

    public void LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        dequqeue = new WghDList();
        total = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            /* �Ͽ����ڽڵ������ */
            Node node = map.get(key);
            dequqeue.removeNode(node);
            /* ���ýڵ��������ĩβ */
            dequqeue.addTail(node);
            return node.val;
        } else return -1;
    }

    public void put(int key, int value) {
        Node tem = new Node(key, value);
        if (map.containsKey(key)) {
            /* �Ͽ����ڽڵ������ */
            Node node = map.get(key);
            dequqeue.removeNode(node);
        }
        map.put(key, tem);
        dequqeue.addTail(tem);
        /* ����ڵ��������� total���Ƴ������ײ��Ľڵ� */
        if (map.size() > total) {
            map.remove(dequqeue.removeHead().key);
        }
    }
}