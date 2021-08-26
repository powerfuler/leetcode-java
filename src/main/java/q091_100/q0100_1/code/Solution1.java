package q091_100.q0100_1.code;

import utils.structure.TreeNode;

/**
 * 标签：深度优先遍历
 *
 * 终止条件与返回值：
 *
 * 当两棵树的当前节点都为 null 时返回 true
 *
 * 当其中一个为 null 另一个不为 null 时返回 false
 *
 * 当两个都不为空但是值不相等时，返回 false
 *
 * 执行过程：当满足终止条件时进行返回，不满足时分别判断左子树和右子树是否相同，其中要注意代码中的短路效应
 *
 * 时间复杂度：O(n)，n 为树的节点个数
 *
 */
public class Solution1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}