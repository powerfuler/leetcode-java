package practice.q0145_二叉树的后序遍历;

import utils.structure.TreeNode;

import java.util.*;

public class test {
    public List<Integer> postorderTraversal(TreeNode head) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(head==null) return res;
        stack.push(head);
        while (!stack.isEmpty()){
            head = stack.pop();
            res.addFirst(head.val);
            if (head.left != null) {
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }
        }

        return res;
    }
}
