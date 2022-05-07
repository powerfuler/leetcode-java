package practice.q094_二叉树的中序遍历;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代
 *
 * 1. 压栈根节点
 * 2. 遍历左子树, 压栈, 直到左子树为空
 * 3. 出栈栈顶元素, 打印
 * 4. 转向右子树, 重复 1, 2, 3步骤
 */
public class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}