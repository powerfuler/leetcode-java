package company.bytedance.q101_q200.q0104_1;

import company.bytedance.q101_q200.q0104_1.code.Solution1;
import org.junit.Test;
import utils.structure.TreeNode;

public class JunitTest {

    @Test
    public void test0() {
        TreeNode treeNode = TreeNode.createTestData("[3,9,20,null,null,15,7]");
        int i = new Solution1().maxDepth(treeNode);
        System.out.println(i);
    }
}
