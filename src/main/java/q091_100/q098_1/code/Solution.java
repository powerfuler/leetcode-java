package q091_100.q098_1.code;

import utils.structure.TreeNode;

/**
 * 中序遍历时，判断当前节点是否大于中序遍历的前一个节点，如果大于，说明满足 BST，继续遍历；否则直接返回 false。
 */
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNode.createTestData("[5,1,4,null,null,3,6]");
        TreeNode treeNode = TreeNode.createTestData("[4,1,6,null,3,5,null]");
        System.out.println(new Solution().isValidBST(treeNode));
    }

}