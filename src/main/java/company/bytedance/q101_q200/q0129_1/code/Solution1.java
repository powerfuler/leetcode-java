package company.bytedance.q101_q200.q0129_1.code;

import utils.structure.TreeNode;

/**
 *
 */
public class Solution1 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            return temp;
        }
        return helper(root.left, temp) +
                helper(root.right, temp);
    }
}