package company.bytedance.q101_q200.q0113_1;

import company.bytedance.q101_q200.q0113_1.code.Solution;
import org.junit.Test;
import utils.structure.TreeNode;

import java.util.List;

public class JunitTest {
    @Test
    public void test0() {
        TreeNode treeNode = TreeNode.createTestData("[5,4,8,11,null,13,4,7,2,null,null,null,null,5,1]");
        int targetSum = 22;
        List<List<Integer>> lists = new Solution().pathSum(treeNode, targetSum);
        System.out.println(lists);
    }
}
