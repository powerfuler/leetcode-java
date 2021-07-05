package company.bytedance.q0124_1;

import company.bytedance.q0124_1.code.Solution1;
import org.junit.Test;
import utils.structure.TreeNode;

public class JunitTest {
    @Test
    public void test0() {
        TreeNode treeNode = TreeNode.createTestData("[-10,9,20,null,null,15,7]");
        long t4 = System.currentTimeMillis();
        int i = new Solution1().maxPathSum(treeNode);
        long t5 = System.currentTimeMillis();
        System.out.println(i);
    }
}
