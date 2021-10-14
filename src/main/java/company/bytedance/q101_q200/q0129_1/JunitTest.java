package company.bytedance.q101_q200.q0129_1;

import company.bytedance.q101_q200.q0129_1.code.Solution1;
import org.junit.Test;
import utils.structure.TreeNode;

public class JunitTest {

    @Test
    public void test0() {
        TreeNode treeNode = TreeNode.createTestData("[4,9,0,5,1]");
        int numbers = new Solution1().sumNumbers(treeNode);
        System.out.println(numbers);
    }
}
