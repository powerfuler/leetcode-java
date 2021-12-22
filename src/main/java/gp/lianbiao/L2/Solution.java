package gp.lianbiao.L2;

import utils.structure.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        l2.val = l1.val + l2.val;
        if (l2.val >= 10) {
            l2.val = l2.val % 10;
            if (l2.next != null) {
                l2.next.val = l2.next.val + 1;
                if (l2.next.val == 10) {
                    l2.next = addTwoNumbers(new ListNode(0), l2.next);
                }
            } else {
                l2.next = new ListNode(1);
            }
        }
        l2.next = addTwoNumbers(l1.next, l2.next);
        return l2;
    }
}