package gp.hash.L133;

import java.util.*;

class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        ArrayList<Node> nodes = getNodes(node);
        Map<Node, Node> mapping = new HashMap<>();
        // copy node
        for (Node n : nodes) {
            mapping.put(n, new Node(n.val));
        }
        //copy neighbors
        for (Node n : nodes) {
            Node newNode = mapping.get(n);
            for (Node neighbor : n.neighbors) {
                Node newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }

    public ArrayList<Node> getNodes(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        HashSet<Node> set = new HashSet<Node>();
        // -> 1
        queue.offer(node);
        // -> 1
        set.add(node);
        while (!queue.isEmpty()) {
            //round 1: head = 1, queue is empty, set - > 1
            //round 2: head = 2, queue -> 4, set -> 1,2,4
            // round 3 head = 4 queue -> 3 , set -> 1,2,3,4
            //round 4 head = 3 queue is empty, set -> 1,2,3,4
            Node head = queue.poll();
            // round 1 neighbors = 2, 4
            // after round 1 set 1,2,4   queue 2,4
            // round 2 neighbors 1,3
            // after loop set -> 1,2,3,4 queue 4, 3
            //round 3 neighbors-> 1,3 queue 3
            // round 4 neighbots -> 2,4 , queue is 
            for (Node neighbor : head.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<Node>(set);
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