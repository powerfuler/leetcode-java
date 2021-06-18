package company.bytedance.q002_1;

import org.junit.Test;
import q001_010.q002_两数相加.code.Solution1;
import q001_010.q002_两数相加.code.Solution2;
import utils.structure.ListNode;

public class JunitTest {

    @Test
    public void test0() {
        ListNode l1 = ListNode.createTestData("[3,4,2]");
        ListNode l2 = ListNode.createTestData("[4,6]");

        long t4 = System.currentTimeMillis();
        ListNode listNode = new Solution2().addTwoNumbers(l1, l2);
        long t5 = System.currentTimeMillis();

        ListNode.print(listNode);
    }

    @Test
    public void test1() {
        ListNode l1 = ListNode.createTestData("[3,4,9]");
        ListNode l2 = ListNode.createTestData("[4,6]");

        long t4 = System.currentTimeMillis();
        ListNode listNode = new Solution1().addTwoNumbers(l1, l2);
        long t5 = System.currentTimeMillis();

        ListNode.print(listNode);
    }
}
