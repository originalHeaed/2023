package month08;

import java.util.*;

/**
 * ʱ�䣺2023/8/30
 * ������������������ ��ͨ ͼ��һ���ڵ�����ã����㷵�ظ�ͼ�� �������¡����
 * �����/���˼·��ʹ�ù���������� + mapӳ������������ڵ����Ѿ��������Ľڵ�
 * ���룺�е�
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
     * ʱ�临�Ӷȣ�O��n��
     * �ռ临�Ӷȣ�O��n��
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        /* ����������� */
        if (node == null) return null;
        /* ʹ�ù���������� */
        Queue<Node> queue = new LinkedList<>(); // �������й����������
        Map<Node, Node> map = new HashMap<>(); // �����Ѿ����ʵı���¡�ڵ����¡�ڵ��ӳ���ϵ
        queue.add(node);
        Node res = new Node(node.val);
        map.put(node, res);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                Node newOne = map.get(poll);
                /* ��������¡�ڵ���������ڽڵ㣬������ڽڵ��Ѿ����ʹ��������贴���½ڵ�ֻ��Ҫ���������Ѿ�����
                 * �ڵ�����ڹ�ϵ��������Ҫ����һ���½ڵ� */
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
     * ʹ�������������
     */
    public Node cloneGraph2(Node node) {
        /* �ݹ����������node Ϊ�ջ��߸ýڵ��Ѿ����ʹ� */
        if (node == null) return null;
        if (hashMap.containsKey(node)) return hashMap.get(node);
        /*��ʼ�ݹ� */
        Node newOne = new Node(node.val); // �½ڵ�
        hashMap.put(node, newOne);
        node.neighbors.stream().forEach(ele -> {
            newOne.neighbors.add(cloneGraph2(ele));
        });
        return newOne;
    }
}