package company.bytedance.q101_q200.q0114_1;

import company.bytedance.q101_q200.q0114_1.code.Solution;
import org.junit.Test;
import utils.structure.TreeNode;

public class JunitTest {

    @Test
    public void test0() {
        TreeNode root = TreeNode.createTestData("[1,2,5,3,4,null,6]");

        long t4 = System.currentTimeMillis();
        new Solution().flatten(root);
        long t5 = System.currentTimeMillis();
//        ListNode.print(intersectionNode);
    }
}
