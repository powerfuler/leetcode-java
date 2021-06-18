package company.bytedance.q002_1;

import q001_010.q002_两数相加.code.Solution1;
import q001_010.q002_两数相加.code.Solution2;
import utils.structure.ListNode;

/*
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/

public class Test {
    public static void main(String[] args) {
        ListNode l1 = ListNode.createTestData("[2,4,3]");
        ListNode l2 = ListNode.createTestData("[5,6,4]");

        long t1 = System.currentTimeMillis();
        ListNode listNode1 = new Solution2().addTwoNumbers(l2, l1);
        long t2 = System.currentTimeMillis();

        long t4 = System.currentTimeMillis();
        ListNode listNode2 = new Solution1().addTwoNumbers(l2, l1);
        long t5 = System.currentTimeMillis();

        System.out.println("time cost is " + (t2 - t1) + " ms;");
        System.out.println("time cost is " + (t5 - t4) + " ms;");

        ListNode.print(listNode2);
    }
}
