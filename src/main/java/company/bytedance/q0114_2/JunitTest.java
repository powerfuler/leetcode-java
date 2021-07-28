package company.bytedance.q0114_2;

import company.bytedance.q0114_2.code.Solution;
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
