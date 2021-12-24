package gp.tree;

import utils.structure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class balancedTree {
     public boolean isBalanced(TreeNode root) {
        // write your code here
         if(root == null) {
            return true;
         }
         return maxTree(root) != -1;
    }
    
    public int maxTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxTree(node.left);
        int right = maxTree(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
    
}