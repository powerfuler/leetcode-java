package company.bytedance.q101_q200.q0111_1.code;

import utils.structure.TreeNode;

public class Solution2 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        if (root.left != null) {
            ans = Math.min(minDepth(root.left), ans);
        }
        if (root.right != null) {
            ans = Math.min(minDepth(root.right), ans);
        }
        return ans + 1;
    }
}