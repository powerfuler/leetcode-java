package q1_1;

import org.junit.Test;
import q2_两数相加.code.ListNode;
import q2_两数相加.code.Solution2;
import utils.CommonUtil;

public class JunitTest {

    @Test
    public void test0() {
        ListNode l1 = new ListNode(3);
        ListNode addnode2 = new ListNode(4);
        l1.next = addnode2;
        ListNode addnode3 = new ListNode(2);
        addnode2.next = addnode3;

        ListNode l2 = new ListNode(4);
        ListNode addnode4 = new ListNode(6);
        l2.next = addnode4;

        long t4 = System.currentTimeMillis();
        ListNode listNode = new Solution2().addTwoNumbers(l1, l2);
        long t5 = System.currentTimeMillis();

        CommonUtil.print(listNode);
    }

}
