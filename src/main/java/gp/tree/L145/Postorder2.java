package gp.tree.L145;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Postorder2 {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.right == null && node.left == null) {
                result.add(stack.pop().val);
            }
            if (node.right != null) {
                stack.push(node.right);
                node.right = null;
            }
            if (node.left != null) {
                stack.push(node.left);
                node.left = null;
            }
        }
        return result;
    }
}