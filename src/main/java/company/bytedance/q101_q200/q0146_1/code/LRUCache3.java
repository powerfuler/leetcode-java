package company.bytedance.q101_q200.q0146_1.code;

import java.util.HashMap;
import java.util.Map;

class LRUCache3 {

    Node head, tail;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.pre = head;
    }


    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        MoveNodeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            MoveNodeToHead(node);
        } else {
            Node currentNode = new Node(key, value);
            if (map.size() >= capacity) {
                removeNode(tail);
                map.remove(tail.key);
            }
            map.put(key, currentNode);
            addNodeToHead(currentNode);
        }
    }

    private void MoveNodeToHead(Node node) {
        removeNode(node);
        addNodeToHead(node);
    }

    private void removeNode(Node node) {
        if (node == tail) {
            tail = node.pre;
            node.next = null;
        } else if (node == head) {
            head = node.next;
            node.next.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    private void addNodeToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
//        ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//                [null, null, null, 1, null, -1, null, -1, 3, 4]
        LRUCache3 lRUCache = new LRUCache3(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }
}
