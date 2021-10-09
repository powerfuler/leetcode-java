package company.bytedance.q101_q200.q0107_1;

import company.bytedance.q101_q200.q0107_1.code.Solution1;
import org.junit.Test;
import utils.structure.TreeNode;

import java.util.List;

public class JunitTest {
    @Test
    public void test0() {
        TreeNode treeNode = TreeNode.createTestData("[3,9,20,null,null,15,7]");
        List<List<Integer>> lists = new Solution1().levelOrderBottom(treeNode);
        System.out.println(lists);
    }
}
