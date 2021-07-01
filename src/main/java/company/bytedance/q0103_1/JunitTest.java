package company.bytedance.q0103_1;

import company.bytedance.q0103_1.code.Solution1;
import org.junit.Test;
import utils.structure.TreeNode;

import java.util.List;

public class JunitTest {
    @Test
    public void test0() {
        TreeNode treeNode = TreeNode.createTestData("[3,9,20,null,null,15,7,null,null,null,null,18,null,null,20]");
        long t4 = System.currentTimeMillis();
        List<List<Integer>> lists = new Solution1().zigzagLevelOrder(treeNode);
        long t5 = System.currentTimeMillis();
        System.out.println(lists);
    }
}