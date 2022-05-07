package practice.q0110_平衡二叉树;

import utils.structure.TreeNode;

/**
 * 采取**后序遍历**的方式遍历二叉树的每一个结点。
 * 在遍历到一个结点之前已经遍历了它的左右子树，那么只要在遍历每个结点的时候记录它的深度（某一结点的深度等于它到叶结点的路径的长度），
 * 就可以一边遍历一边判断每个结点是不是平衡的。
 *
 */
public class Solution1 {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return right > left ? right + 1 : left + 1;
    }
}