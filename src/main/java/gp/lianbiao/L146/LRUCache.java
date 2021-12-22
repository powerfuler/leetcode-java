package gp.lianbiao.L146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Node head, tail;
    int capacity;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            flushNodeToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            flushNodeToHead(node);
        } else {
            node = new Node(key, value);
            if (map.size() >= capacity) {
                removeNode(tail);
                map.remove(tail.key);
            }
            addNodeToHead(node);
            map.put(key, node);
        }
    }

    public void flushNodeToHead(Node node) {
        removeNode(node);
        addNodeToHead(node);
    }

    public void addNodeToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public void removeNode(Node node) {
        if (node == head) {
            head = head.next;
            head.pre = null;
        } else if (node == tail) {
            tail = tail.pre;
            tail.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }
}

class Node {
    Node pre;
    Node next;

    int key;
    int value;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}