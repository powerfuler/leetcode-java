package company.bytedance.q101_q200.q0106_1;

import company.bytedance.q101_q200.q0106_1.code.Solution1;
import org.junit.Test;
import utils.structure.TreeNode;

public class JunitTest {

    @Test
    public void test0() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode1 = new Solution1().buildTree(inorder, postorder);
        TreeNode.print(treeNode1);
    }
}
