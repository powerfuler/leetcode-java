package practice.q0160_相交链表;

import utils.structure.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int c1 = 0, c2 = 0;
        ListNode t1 = headA, t2 = headB;
        while (t1 != null) {
            c1++;
            t1 = t1.next;
        }
        while (t2 != null) {
            c2++;
            t2 = t2.next;
        }
        int t = Math.abs(c1 - c2);
        while (t-- > 0) {
            if (c1 > c2) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
        }

        while (headB != null && headA != null) {
            if (headB.equals(headA)) {
                return headB;
            } else {
                headB = headB.next;
                headA = headA.next;
            }
        }
        return null;
    }
}
