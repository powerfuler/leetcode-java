package gp.lianbiao.L138;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node newHead = head;
        while (newHead != null) {
            if (!map.containsKey(newHead)) {
                Node node = new Node(newHead.val);
                map.put(newHead, node);
            }
            if (newHead.random != null) {
                Node random = newHead.random;
                if (!map.containsKey(random)) {
                    Node copyRandom = new Node(random.val);
                    map.put(random, copyRandom);
                }
                map.get(newHead).random = map.get(random);
            }
            newHead = newHead.next;
        }
        newHead = head;
        while (newHead != null) {
            Node next = newHead.next;
            map.get(newHead).next = map.get(next);
            newHead = newHead.next;
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}