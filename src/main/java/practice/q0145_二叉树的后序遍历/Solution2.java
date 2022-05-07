package practice.q0145_二叉树的后序遍历;

import utils.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 递归
 */
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode head) {
        List<Integer> list = new LinkedList<>();
        if (head == null) {
            return list;
        }
        postorderTraversal(head,list);
        return list;
    }

    public void postorderTraversal(TreeNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        postorderTraversal(head.left,list);
        postorderTraversal(head.right,list);
        list.add(head.val);
    }
}
