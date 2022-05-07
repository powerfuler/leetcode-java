package practice.q0144_二叉树的前序遍历;

import utils.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代
 *  用栈(Stack)**的思路来处理问题。
 *
 *  前序遍历的顺序为**根-左-右**，具体算法为：
 *
 * - 把根节点 push 到栈中
 * - 循环检测栈是否为空，若不空，则取出栈顶元素，保存其值
 * - 看其右子节点是否存在，若存在则 push 到栈中
 * - 看其左子节点，若存在，则 push 到栈中。
 *
 */
public class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        //非递归前序遍历，需要借助栈
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        //当树为空树时，直接返回一个空`list
        if (root == null) {
            return list;
        }
        //第一步是将根节点压入栈中
        stack.push(root);
        //当栈不为空时，出栈的元素插入list尾部。
        //当它的孩子不为空时，将孩子压入栈，一定是先压右孩子再压左孩子
        while (!stack.isEmpty()) {
            //此处的root只是一个变量的复用
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return list;
    }
}