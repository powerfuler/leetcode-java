package company.bytedance.q101_q200.q0108_1.code;

import utils.structure.TreeNode;

/**
 *题意：根据升序数组，恢复一棵高度平衡的BST🌲。
 *
 * 分析：BST的中序遍历是升序的，因此本题等同于根据中序遍历的序列恢复二叉搜索树。
 * 因此我们可以以升序序列中的任一个元素作为根节点，以该元素左边的升序序列构建左子树，以该元素右边的升序序列构建右子树，
 * 这样得到的树就是一棵二叉搜索树啦～
 * 又因为本题要求高度平衡，因此我们需要选择升序序列的中间元素作为根节点奥～
 *
 */
public class Solution1 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        // 以升序数组的中间元素作为根节点 root。
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 递归的构建 root 的左子树与右子树。
        root.left = dfs(nums, lo, mid - 1);
        root.right = dfs(nums, mid + 1, hi);
        return root;
    }
}