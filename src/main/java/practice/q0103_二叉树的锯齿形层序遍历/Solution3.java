package practice.q0103_二叉树的锯齿形层序遍历;

import utils.structure.TreeNode;

import java.util.*;

public class Solution3 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        boolean left = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> deque = new ArrayDeque<>();
            while (size > 0) {
                TreeNode poll = queue.poll();
                size--;
                if (left) {
                    // 左 -> 右
                    deque.offerFirst(poll.val);
                } else {
                    deque.offerLast(poll.val);
                }
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            left = !left;
            ans.add(new ArrayList<>(deque));
        }
        return ans;
    }
}