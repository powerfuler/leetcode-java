package gp.tree.L110;

import utils.structure.TreeNode;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return maxTree(root) != -1;
    }

    public int maxTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxTree(root.left);
        int right = maxTree(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}