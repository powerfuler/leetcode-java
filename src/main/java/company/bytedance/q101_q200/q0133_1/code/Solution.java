package company.bytedance.q101_q200.q0133_1.code;

import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        List<Node> nodes = getNodes(node);

        Map<Node, Node> mapping = new HashMap<>();
        for (Node n : nodes) {
            mapping.put(n, new Node(n.val));
        }
        // copy neighbors
        for (Node n : nodes) {
            Node newNode = mapping.get(n);
            List<Node> neighbors = n.neighbors;
            for (Node neighbor : neighbors) {
                Node newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }

    private List<Node> getNodes(Node node) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            List<Node> neighbors = poll.neighbors;
            for (Node neighbor : neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(set);
    }
}


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
