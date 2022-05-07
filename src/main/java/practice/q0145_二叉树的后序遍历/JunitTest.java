package practice.q0145_二叉树的后序遍历;

import practice.q0145_二叉树的后序遍历.code.Solution;
import org.junit.Test;
import utils.structure.TreeNode;

import java.util.List;

public class JunitTest {

    @Test
    public void test0() {
        TreeNode root = TreeNode.createTestData("[1,null,2,null,null,3,null]");
        long t4 = System.currentTimeMillis();
        List<Integer> integers = new Solution().postorderTraversal(root);
        long t5 = System.currentTimeMillis();
        System.out.println(integers);

    }
}
