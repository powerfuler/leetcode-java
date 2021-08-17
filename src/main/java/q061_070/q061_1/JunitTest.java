package q061_070.q061_1;

import org.junit.Test;
import q061_070.q061_1.code.Solution;
import utils.structure.ListNode;

public class JunitTest {
    @Test
    public void test0() {
        ListNode n1 = ListNode.createTestData("[1,2,3,4,5]");
        long t4 = System.currentTimeMillis();
        ListNode listNode = new Solution().rotateRight(n1, 2);
        long t5 = System.currentTimeMillis();
        ListNode.print(listNode);
    }
}
