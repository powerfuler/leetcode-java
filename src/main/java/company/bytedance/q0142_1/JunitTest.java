package company.bytedance.q0142_1;

import company.bytedance.q0142_1.code.Solution1;
import org.junit.Test;
import utils.structure.ListNode;

public class JunitTest {
    @Test
    public void test0() {
        ListNode l1 = ListNode.createTestData("[2,4,5,6,5,4,2]");
        ListNode l2 = l1;
        while (l2.next != null) {
            l2 = l2.next;
        }
        l2.next = l1.next.next;

        ListNode listNode = new Solution1().detectCycle(l1);
        long t2 = System.currentTimeMillis();
        ListNode.print(listNode);
    }
}
