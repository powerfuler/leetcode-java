package gp.tree;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Inorder1 {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);

        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
    }
}