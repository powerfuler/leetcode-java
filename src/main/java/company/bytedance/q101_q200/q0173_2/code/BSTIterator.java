package company.bytedance.q101_q200.q0173_2.code;

import utils.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("ALL")
class BSTIterator {
    Deque<TreeNode> d = new ArrayDeque<>();
    public BSTIterator(TreeNode root) {
        // 步骤 1
        dfsLeft(root);
    }
    
    public int next() {
        // 步骤 2
        TreeNode root = d.pollLast();
        int ans = root.val;
        // 步骤 3
        root = root.right;
        // 步骤 1
        dfsLeft(root);
        return ans;
    }

    void dfsLeft(TreeNode root) {
        while (root != null) {
            d.addLast(root);
            root = root.left;
        }
    }
    
    public boolean hasNext() {
        return !d.isEmpty();
    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTestData("[7, 3, 15, null, null, 9, 20]");
        BSTIterator bSTIterator = new BSTIterator(treeNode);
        bSTIterator.next();    // 返回 3
        bSTIterator.next();    // 返回 7
        bSTIterator.hasNext(); // 返回 True
        bSTIterator.next();    // 返回 9
        bSTIterator.hasNext(); // 返回 True
        bSTIterator.next();    // 返回 15
        bSTIterator.hasNext(); // 返回 True
        bSTIterator.next();    // 返回 20
        bSTIterator.hasNext(); // 返回 False
    }
}