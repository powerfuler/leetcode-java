package company.bytedance.q0143_1;

import company.bytedance.q0143_1.code.Solution1;
import org.junit.Test;
import utils.structure.ListNode;

public class JunitTest {
    @Test
    public void test0() {
        ListNode l1 = ListNode.createTestData("[1,2,3,4,5,6]");
        long t4 = System.currentTimeMillis();
        ListNode listNode = new Solution1().reorderList(l1);
        long t5 = System.currentTimeMillis();
        ListNode.print(listNode);
    }
}
