package company.bytedance.q0112_1.code;

import utils.structure.TreeNode;

/**
 * DFS\递归
 */
public class Solution1 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum);
            if (left) {// 已经找到
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetSum);
            if (right) {// 已经找到
                return true;
            }
        }
        return false;
    }

    // LC112 简洁方法
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false; // 为空退出
        // 叶子节点判断是否符合
        if (root.left == null && root.right == null) return root.val == targetSum;
        // 求两侧分支的路径和
        return hasPathSum2(root.left, targetSum - root.val)
                || hasPathSum2(root.right, targetSum - root.val);
    }


    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            return (num - root.val) == 0;
        }
        if (root.left != null && dfs(root.left, num - root.val)) {
            return true;
        }
        return root.right != null && dfs(root.right, num - root.val);
    }
}