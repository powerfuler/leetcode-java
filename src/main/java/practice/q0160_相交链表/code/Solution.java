package practice.q0160_相交链表.code;

import utils.structure.ListNode;

/**
 * 差值解法
 * 先对两条链表扫描一遍，取得两者长度，然后让长的链表先走「两者的长度差值」，然后再同时走，遇到第一个节点即是答案。
 *
 * 时间复杂度：$O(n + m)$
 * 空间复杂度：$O(1)$
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int c1 = 0, c2 = 0;
        ListNode t1 = headA, t2 = headB;
        while (t1 != null && ++c1 > 0) t1 = t1.next;
        while (t2 != null && ++c2 > 0) t2 = t2.next;
        int t = Math.abs(c1 - c2);
        while (t-- > 0) {
            if (c1 > c2) headA = headA.next;
            else headB = headB.next;
        }
        while (headA != null && headB != null) {
            if (headA.equals(headB)) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}