package company.bytedance.q0206_1.code;

import utils.structure.ListNode;

/**
 * 递归法 o(n)
 */
class Solution4 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
