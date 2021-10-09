package company.bytedance.q101_q200.q0101_1;

import company.bytedance.q101_q200.q0101_1.code.Solution1;
import org.junit.Test;
import utils.structure.TreeNode;

public class JunitTest {

    @Test
    public void test0() {
//        TreeNode treeNode = TreeNode.createTestData("[1,2,2,3,4,4,3]");
        TreeNode treeNode = TreeNode.createTestData("[1,2,2,null,3,null,3]");
        long t4 = System.currentTimeMillis();
        boolean symmetric = new Solution1().isSymmetric(treeNode);
        long t5 = System.currentTimeMillis();
        System.out.println(symmetric);
    }
}
