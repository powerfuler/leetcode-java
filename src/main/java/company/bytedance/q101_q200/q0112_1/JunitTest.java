package company.bytedance.q101_q200.q0112_1;

import company.bytedance.q101_q200.q0112_1.code.Solution1;
import org.junit.Test;
import utils.structure.TreeNode;

public class JunitTest {
    @Test
    public void test0() {
        TreeNode treeNode = TreeNode.createTestData("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        int targetSum = 22;
        System.out.println(new Solution1().hasPathSum(treeNode, targetSum));
    }
}
