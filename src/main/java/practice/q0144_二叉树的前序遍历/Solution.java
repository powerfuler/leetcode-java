package practice.q0144_二叉树的前序遍历;

import utils.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 递归
 */
public class Solution {
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
