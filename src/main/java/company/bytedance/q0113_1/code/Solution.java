package company.bytedance.q0113_1.code;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new LinkedList<>();
        dfs(root, targetSum, res, path);
        return res;
    }

    public void dfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        // 遇到了叶子节点
        if (root.left == null && root.right == null) {
            // 找到了和为 targetSum 的路径
            if (targetSum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return; // 如果和不为 targetSum，返回
        }

        if (root.left != null) {
            dfs(root.left, targetSum - root.val, res, path);
            // 回溯
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, targetSum - root.val, res, path);
            path.remove(path.size() - 1);
        }
    }
}