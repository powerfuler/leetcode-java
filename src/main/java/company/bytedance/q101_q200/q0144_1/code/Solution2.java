package company.bytedance.q101_q200.q0144_1.code;

import utils.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 递归
 */
public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode head) {
        List<Integer> list = new LinkedList<>();
        if (head == null) {
            return list;
        }
        preorderTraversal(head,list);
        return list;
    }

    public void preorderTraversal(TreeNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        list.add(head.val);
        preorderTraversal(head.left,list);
        preorderTraversal(head.right,list);
    }
}
