package practice.q094_二叉树的中序遍历;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归 o(n) 迭代
 *
 * 1. 压栈根节点
 * 2. 遍历左子树, 压栈, 直到左子树为空
 * 3. 出栈栈顶元素, 打印
 * 4. 转向右子树, 重复 1, 2, 3步骤
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            rs.add(root.val);
            root = root.right;
        }
        return rs;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTestData("[1,null,2,null,null,3,null]");
        List<Integer> integers = new Solution2().inorderTraversal(treeNode);
        System.out.println(integers);
    }
}
