package gp.tree.L103;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (reverse) {
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
            reverse = !reverse;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTestData("[3,9,20,null,null,15,7]");
        List<List<Integer>> lists = new Solution().zigzagLevelOrder(treeNode);
    }
}