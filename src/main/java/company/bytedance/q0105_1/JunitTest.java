package company.bytedance.q0105_1;

import company.bytedance.q0105_1.code.Solution3;
import org.junit.Test;
import utils.structure.TreeNode;

public class JunitTest {

    @Test
    public void test0() {

        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = new Solution3().buildTree(preorder, inorder);

        TreeNode.print(treeNode);
    }
}
