package company.bytedance.q101_q200.q0106_1.code;

import utils.structure.TreeNode;

import java.util.HashMap;

/**
 *
 */
public class Solution1 {
    HashMap<Integer, Integer> inorderArrayMap = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            // 将节点值及索引全部记录在哈希表中
            inorderArrayMap.put(inorder[i], i);
        }
        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (inorderEnd < inorderStart || postorderEnd < postorderStart) {
            return null;
        }
        // 根据后序遍历结果，取得根节点
        int root = post[postorderEnd];
        //获取对应的索引
        int rootIndexInInorderArray = inorderArrayMap.get(root);
        // 创建该节点
        TreeNode node = new TreeNode(root);
        node.left = buildTree(inorderStart, rootIndexInInorderArray - 1, postorderStart, postorderStart + rootIndexInInorderArray - inorderStart - 1);
        node.right = buildTree(rootIndexInInorderArray + 1, inorderEnd, postorderStart + rootIndexInInorderArray - inorderStart, postorderEnd - 1);
        // 返回的是新建的node！
        return node;
    }
}