package company.bytedance.q0144_1;

import company.bytedance.q0144_1.code.Solution2;
import org.junit.Test;
import utils.structure.TreeNode;

import java.util.List;

public class JunitTest {
    @Test
    public void test0() {
        TreeNode root = TreeNode.createTestData("[1,null,2,null,null,3,null]");
        long t4 = System.currentTimeMillis();
        List<Integer> integers = new Solution2().preorderTraversal(root);
        long t5 = System.currentTimeMillis();
        System.out.println(integers);
    }
}
