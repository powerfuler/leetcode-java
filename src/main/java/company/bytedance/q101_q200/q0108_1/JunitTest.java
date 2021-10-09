package company.bytedance.q101_q200.q0108_1;

import company.bytedance.q101_q200.q0108_1.code.Solution1;
import org.junit.Test;
import utils.structure.TreeNode;

public class JunitTest {

    @Test
    public void test0() {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = new Solution1().sortedArrayToBST(nums);
        TreeNode.print(treeNode);
    }
}
