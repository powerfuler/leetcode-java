package gp.tree.L199;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return result;
        }
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int deep) {
        if(root== null){
            return;
        }
        if (deep == result.size()) {
            result.add(root.val);
        }
        deep++;
        dfs(root.right, deep);
        dfs(root.left, deep);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTestData("[1,2,3,null,5,null,null]");
        new Solution().rightSideView(treeNode);
    }
}