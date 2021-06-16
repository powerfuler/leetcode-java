package company.bytedance.q0234_1;

/*
 */

import company.bytedance.q0234_1.code.Solution2;
import utils.structure.ListNode;

public class Test {
    public static void main(String[] args) {
        ListNode l1 = ListNode.createTestData("[2,4,5,6,5,4,2]");
        long t1 = System.currentTimeMillis();
        boolean palindrome = new Solution2().isPalindrome(l1);
        long t2 = System.currentTimeMillis();
        System.out.println(palindrome);
        ListNode.print(l1);
    }
}
