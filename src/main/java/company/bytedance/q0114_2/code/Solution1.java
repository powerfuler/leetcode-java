package company.bytedance.q0114_2.code;

import utils.structure.TreeNode;

import java.util.Stack;

/**
 *
 *
 */
public class Solution1 {
    public void flatten(TreeNode root) {
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur); // 添加根节点
                cur = cur.right; // 递归添加右节点
            }
            cur = toVisit.peek(); // 已经访问到最右的节点了
            // 在不存在左节点或者右节点已经访问过的情况下，访问根节点
            if (cur.left == null || cur.left == pre) {
                toVisit.pop();
                /**************修改的地方***************/
                cur.right = pre;
                cur.left = null;
                /*************************************/
                pre = cur;
                cur = null;
            } else {
                cur = cur.left; // 左节点还没有访问过就先访问左节点
            }
        }
    }
}