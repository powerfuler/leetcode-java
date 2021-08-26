package q091_100.q099_1.code;

import utils.structure.TreeNode;

/**
 * 莫里斯遍历
 */
class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pre = null;
        TreeNode tmp = null;
        while (root != null) {
            if (root.left != null) {
                tmp = root.left;
                while (tmp.right != null && tmp.right != root) {
                    tmp = tmp.right;
                }
                if (tmp.right == null) {
                    tmp.right = root;
                    root = root.left;
                } else {
                    if (pre != null && pre.val > root.val) {
                        y = root;
                        if (x == null) {
                            x = pre;
                        }
                    }
                    pre = root;
                    tmp.right = null;
                    root = root.right;
                }
            } else {
                if (pre != null && pre.val > root.val) {
                    y = root;
                    if (x == null) {
                        x = pre;
                    }
                }
                pre = root;
                root = root.right;
            }
        }
        if (x != null && y != null) {
            int t = x.val;
            x.val = y.val;
            y.val = t;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTestData("[3,1,4,null,null,2]");
        new Solution().recoverTree(treeNode);
        TreeNode.print(treeNode);
    }
}