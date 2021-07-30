package company.bytedance.q101_q200.q0141_1.code;

import utils.structure.ListNode;

/**
 * 快慢指针 o(n)
 *
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}