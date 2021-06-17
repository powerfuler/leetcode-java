package company.bytedance.q0206_1;

import company.bytedance.q0206_1.code.Solution1;
import utils.structure.ListNode;

public class Test {
    public static void main(String[] args) {
        ListNode l1 = ListNode.createTestData("[2,4,5,6,7]");
        long t1 = System.currentTimeMillis();
        ListNode reverse = new Solution1().reverse(l1);
        long t2 = System.currentTimeMillis();
        ListNode.print(reverse);
    }
}
