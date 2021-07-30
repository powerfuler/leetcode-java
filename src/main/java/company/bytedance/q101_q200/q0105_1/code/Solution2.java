package company.bytedance.q101_q200.q0105_1.code;

import utils.structure.TreeNode;

import java.util.HashMap;

/**
 *
 *  int[] preorder = new int[]{3, 9, 20, 15, 7};
 *  int[] inorder = new int[]{9, 3, 15, 20, 7};
 */
public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, HashMap<Integer, Integer> map) {
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = map.get(root_val);
        int leftNum = i_root_index - i_start;
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index, map);
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end, map);
        return root;
    }
}

//class Solution {
//    TreeNode buildTree(int[] preorder, int[] inorder) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        return builder(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
//    }
//
//    private TreeNode builder(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, HashMap<Integer, Integer> map) {
//        if (p_start == p_end) return null;
//
//        int rootval = preorder[p_start];
//        TreeNode root = new TreeNode(rootval);
//        int i = map.get(rootval);
//        int leftNum = i - i_start;
//        root.left = builder(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i, map);
//        root.right = builder(preorder, p_start + leftNum + 1, p_end, inorder, i, i_end, map);
//        return root;
//    }
//}