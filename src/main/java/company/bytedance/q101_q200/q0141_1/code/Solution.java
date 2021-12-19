package company.bytedance.q101_q200.q0141_1.code;

import utils.structure.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.createTestData("[2,4,5,6,5,4,2]");
        ListNode l2 = l1.next.next ;
        while (l1.next != null){
            l1 = l1.next;
        }
        l1.next = l2;
        boolean palindrome = new Solution1().hasCycle(l1);
        System.out.println(palindrome);
    }
}