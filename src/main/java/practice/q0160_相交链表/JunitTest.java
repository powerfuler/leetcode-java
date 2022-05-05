package practice.q0160_相交链表;

import practice.q0160_相交链表.code.Solution;
import org.junit.Test;
import utils.structure.ListNode;

public class JunitTest {

    @Test
    public void test0() {
//        ListNode l1 = ListNode.createTestData("[4,1,8,4,5]");
//        ListNode l2 = ListNode.createTestData("[5,0,1,8,4,5]");


        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode l3 = new ListNode(8);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        a1.next = a2;
        a2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(1);

        b1.next = b2;
        b2.next = b3;
        b3.next = l3;
        l3.next = l4;
        l4.next = l5;


        long t4 = System.currentTimeMillis();
        ListNode intersectionNode = new Solution().getIntersectionNode(a1, b1);
        long t5 = System.currentTimeMillis();
        ListNode.print(intersectionNode);
    }
}
