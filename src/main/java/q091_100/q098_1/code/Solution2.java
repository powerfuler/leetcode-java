package q091_100.q098_1.code;

import utils.structure.TreeNode;

/**
 * 寻找上下界递归 o(n)
 */
public class Solution2 {
    public boolean valid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        int val = root.val;

        if (min != null && val <= min) {
            return false;
        }
        if (max != null && val >= max) {
            return false;
        }

        if (!valid(root.left, min, val)) {
            return false;
        }
        if (!valid(root.right, val, max)) {
            return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNode.createTestData("[5,1,4,null,null,3,6]");
        TreeNode treeNode = TreeNode.createTestData("[4,1,6,null,3,5,null]");
        System.out.println(new Solution2().isValidBST(treeNode));
    }
}
