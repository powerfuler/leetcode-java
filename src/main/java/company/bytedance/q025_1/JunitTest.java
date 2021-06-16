package company.bytedance.q025_1;

import company.bytedance.q025_1.code.Solution1;
import org.junit.Test;
import utils.structure.ListNode;

public class JunitTest {
    @Test
    public void test0() {
        ListNode n1 = ListNode.createTestData("[1,2,3,4,5]");
        long t1 = System.currentTimeMillis();
        ListNode listNode = new Solution1().reverseKGroup(n1, 3);
        long t2 = System.currentTimeMillis();
        System.out.println(listNode);
    }
}
