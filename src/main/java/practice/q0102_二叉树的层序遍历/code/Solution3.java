package practice.q0102_二叉树的层序遍历.code;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 利用队列迭代 o(n)
 */
public class Solution3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {

            levels.add(new ArrayList<>());

            int levelLength = queue.size();

            for (int i = 0; i < levelLength; ++i) {
                // 取出当前层数据，把数据放到list
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);
                // 把当前层的左右子树再次放到队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return levels;
    }
}
