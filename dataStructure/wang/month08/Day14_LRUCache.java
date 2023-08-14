package month08;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 时间：2023/8/14
 * 问题描述：
 *  设计一个 LRU 的实现
 * 切入点/解决思路：使用 map + 双向链表
 * 感想：中等偏上
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
     * 自定义双端队列
     */
    class WghDList {
        /**
         * 双向链表的头指针
         */
        Node head;

        /**
         * 双向链表的尾指针
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
         * 移除头部元素
         */
        public Node removeHead() {
            if (amount == 0) return null;
            amount--;
            return removeNode(head.next);
        }

        /**
         * 移除指定元素
         */
        public Node removeNode(Node node) {
            if (node == null) return null;
            node.next.pre = node.pre;
            node.pre.next = node.next;
            return node;
        }

        /**
         * 移除尾部元素
         */
        public Node removeTail() {
            if (amount == 0) return null;
            amount--;
            return removeNode(tail.pre);
        }

        /**
         * 将节点加入到双向链表尾部
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
     * 用来存储键值对以及快速找到和更新值
     */
    Map<Integer, Node> map;

    /**
     * 双向链表
     */
    WghDList dequqeue;

    int total; // 链表中允许存在最大的元素总个数

    public void LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        dequqeue = new WghDList();
        total = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            /* 断开存在节点的连接 */
            Node node = map.get(key);
            dequqeue.removeNode(node);
            /* 将该节点加入链表末尾 */
            dequqeue.addTail(node);
            return node.val;
        } else return -1;
    }

    public void put(int key, int value) {
        Node tem = new Node(key, value);
        if (map.containsKey(key)) {
            /* 断开存在节点的连接 */
            Node node = map.get(key);
            dequqeue.removeNode(node);
        }
        map.put(key, tem);
        dequqeue.addTail(tem);
        /* 如果节点总数超过 total，移除链表首部的节点 */
        if (map.size() > total) {
            map.remove(dequqeue.removeHead().key);
        }
    }
}