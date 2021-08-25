package q091_100.q098_1.code;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归的中序遍历 o(n)
 * （二叉搜索树的中序遍历是有序的）
 *
 */
public class Solution1 {

    List<Integer> rs = new ArrayList<>();

    private List<Integer> ldr(TreeNode root) {
        if (root == null) {
            return rs;
        }
        ldr(root.left);
        rs.add(root.val);
        ldr(root.right);
        return rs;
    }

    public boolean isValidBST(TreeNode root) {
        ldr(root);
        if (rs.size() < 2) {
            return true;
        }
        int a = rs.get(0);
        // 后一个元素要比前一个元素大，有序
        for (int i = 1; i < rs.size(); i++) {
            if (rs.get(i) <= a) {
                return false;
            }
            a = rs.get(i);
        }
        return true;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNode.createTestData("[5,1,4,null,null,3,6]");
        TreeNode treeNode = TreeNode.createTestData("[4,1,6,null,3,5,null]");
        System.out.println(new Solution1().isValidBST(treeNode));
    }
}