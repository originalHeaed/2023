package month08;

import java.util.*;

/**
 * 时间：2023/8/30
 * 问题描述：给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 切入点/解决思路：使用广度优先搜索 + map映射来访问深拷贝节点中已经被创建的节点
 * 感想：中等
 */
public class Day30_cloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        /* 特殊情况处理 */
        if (node == null) return null;
        /* 使用广度优先搜索 */
        Queue<Node> queue = new LinkedList<>(); // 用来进行广度优先搜索
        Map<Node, Node> map = new HashMap<>(); // 保持已经访问的被克隆节点与克隆节点的映射关系
        queue.add(node);
        Node res = new Node(node.val);
        map.put(node, res);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                Node newOne = map.get(poll);
                /* 遍历被克隆节点的所有相邻节点，如果相邻节点已经访问过，则无需创建新节点只需要建立两个已经创建
                 * 节点的相邻关系；否则需要创建一个新节点 */
                poll.neighbors.stream().forEach(ele -> {
                    if (!map.containsKey(ele)) {
                        queue.add(ele);
                        map.put(ele, new Node(ele.val));
                    }
                    newOne.neighbors.add(map.get(ele));
                });
            }
        }
        return res;
    }

    Map<Node, Node> hashMap = new HashMap<>();

    /**
     * 使用深度优先搜索
     */
    public Node cloneGraph2(Node node) {
        /* 递归结束条件，node 为空或者该节点已经访问过 */
        if (node == null) return null;
        if (hashMap.containsKey(node)) return hashMap.get(node);
        /*开始递归 */
        Node newOne = new Node(node.val); // 新节点
        hashMap.put(node, newOne);
        node.neighbors.stream().forEach(ele -> {
            newOne.neighbors.add(cloneGraph2(ele));
        });
        return newOne;
    }
}