package company.bytedance.q101_q200.q0173_2.code;

import utils.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

class BSTIterator1 {
    List<Integer> list = new ArrayList<>();
    int index = 0;

    public BSTIterator1(TreeNode root) {
        inorder(root);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}