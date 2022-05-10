package practice.q0103_二叉树的锯齿形层序遍历;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root, res, 0);
        return res;
    }

    private void traversal(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        // 每增加一层，创建ArrayList一个
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        // 判断是从左到右，还是从右到左。奇数层右-->左
        if ((level & 1) == 1) {
            res.get(level).add(0, root.val);
        } else { // 左 -->右
            res.get(level).add(root.val);
        }
        traversal(root.left, res, level + 1);
        traversal(root.right, res, level + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTestData("[3,9,20,null,null,15,7,null,null,null,null,18,null,null,20]");
        List<List<Integer>> lists = new Solution1().zigzagLevelOrder(treeNode);
        System.out.println(lists);
    }
}