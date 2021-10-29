package company.bytedance.q101_q200.q0138_1.code;

import java.util.HashMap;

/**
 * 用Map存储遍历过的节点，时间o(n)，额外空间o(n)
 */
public class Solution1 {

    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        Node node = new Node(head.val);

        this.visitedHash.put(head, node);
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }
}