package company.bytedance.q101_q200.q0105_1;

/*
 */

import company.bytedance.q101_q200.q0105_1.code.Solution2;
import utils.structure.TreeNode;

public class Test {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = new Solution2().buildTree(preorder, inorder);

        TreeNode.print(treeNode);
    }
}
