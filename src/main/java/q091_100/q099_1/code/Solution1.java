package q091_100.q099_1.code;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 注意题目给出的条件，是 二叉搜索树，这就是意味着节点之间是有顺序关系的。
 * 如果我们把整棵树都 遍历 一遍，将遍历的结果保存下来，比如放到一个数组中。
 * 那么这个数组应该是有序的。
 *
 * 既然是有序的那就好办了，我们将这个有序的数组遍历一遍。
 * 如果数组是完全有序的，那么直接返回就可以了。
 * 否则，我们找到顺序不一致的两个下标i和j，将arr[i].val和arr[j].val的值互换一下即可。
 *
 */
public class Solution1 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        TreeNode x = null;
        TreeNode y = null;
        // 扫面遍历的结果，找出可能存在错误交换的节点x和y
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i).val > list.get(i + 1).val) {
                y = list.get(i + 1);
                if (x == null) {
                    x = list.get(i);
                }
            }
        }
        // 如果x和y不为空，则交换这两个节点值，恢复二叉搜索树
        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    /**
     * 中序遍历二叉树，并将遍历的结果保存到list中
     */
    private void dfs(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTestData("[3,1,4,null,null,2]");
        new Solution1().recoverTree(treeNode);
        TreeNode.print(treeNode);
    }
}