package q01_2;

import org.junit.Test;
import utils.structure.ListNode;
import utils.structure.TreeNode;

public class JunitTest {

    @Test
    public void test0() {
        ListNode a= ListNode.createTestData("[4,1,8,4,5]");
        TreeNode treeNode = TreeNode.createTestData("[5]");
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        long t4 = System.currentTimeMillis();
//        ListNode intersectionNode = new Solution1().getIntersectionNode(l1, l2);
        long t5 = System.currentTimeMillis();
//        ListNode.print(intersectionNode);
//        System.out.println(jump);

    }
}
