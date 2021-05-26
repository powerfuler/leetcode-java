package q001_010.q002_两数相加;

import org.junit.Test;
import q001_010.q002_两数相加.code.Solution1;
import q001_010.q002_两数相加.code.Solution2;
import utils.CommonUtil;
import entity.ListNode;

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

    @Test
    public void test1() {
        ListNode l1 = new ListNode(3);
        ListNode addnode2 = new ListNode(4);
        l1.next = addnode2;
        ListNode addnode3 = new ListNode(9);
        addnode2.next = addnode3;

        ListNode l2 = new ListNode(4);
        ListNode addnode4 = new ListNode(6);
        l2.next = addnode4;

        long t4 = System.currentTimeMillis();
        ListNode listNode = new Solution1().addTwoNumbers(l1, l2);
        long t5 = System.currentTimeMillis();

        CommonUtil.print(listNode);
    }
}
