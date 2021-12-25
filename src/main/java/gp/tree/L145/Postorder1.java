package gp.tree.L145;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Postorder1 {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);

        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        return result;
    }
}