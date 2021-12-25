package gp.tree.L199;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

class LeftView {
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
        dfs(root.left, deep);
        dfs(root.right, deep);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTestData("[1,2,3,null,5,null,4]");
        List<Integer> list = new LeftView().rightSideView(treeNode);
        System.out.println(list);
    }
}