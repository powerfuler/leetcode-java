package company.bytedance.q101_q200.q0145_1.code;

import utils.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 *
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
