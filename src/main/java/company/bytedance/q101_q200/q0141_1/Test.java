package company.bytedance.q101_q200.q0141_1;

import company.bytedance.q101_q200.q0141_1.code.Solution1;
import utils.structure.ListNode;

public class Test {
    public static void main(String[] args) {
        ListNode l1 = ListNode.createTestData("[2,4,5,6,5,4,2]");
        long t1 = System.currentTimeMillis();
        ListNode l2 = l1.next.next ;
        while (l1.next != null){
            l1 = l1.next;
        }
        l1.next = l2;
        boolean palindrome = new Solution1().hasCycle(l1);
        long t2 = System.currentTimeMillis();
        System.out.println(palindrome);
//        ListNode.print(l1);
    }
}
