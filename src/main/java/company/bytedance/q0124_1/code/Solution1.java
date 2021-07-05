package company.bytedance.q0124_1.code;

import utils.structure.TreeNode;

/**
 *
 *
 */
public class Solution1 {

    private int maximum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return maximum;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果左右子树返回的最大路径值小于 0 ,直接将值设为 0，也就是不考虑对应的路径
        int leftMax = Math.max(0, helper(root.left));
        int rightMax = Math.max(0, helper(root.right));

        maximum = Math.max(root.val + leftMax + rightMax, maximum);

        return Math.max(leftMax + root.val, rightMax + root.val);
    }
}