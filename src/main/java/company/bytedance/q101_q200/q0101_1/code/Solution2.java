package company.bytedance.q101_q200.q0101_1.code;

import utils.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 利用队列的层序遍历（广度优先搜索BFS）o(n)
 */
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTestData("[1,2,2,3,4,4,3]");
//        TreeNode treeNode = TreeNode.createTestData("[1,2,2,null,3,null,3]");
        boolean symmetric = new Solution2().isSymmetric(treeNode);
        System.out.println(symmetric);
    }
}
