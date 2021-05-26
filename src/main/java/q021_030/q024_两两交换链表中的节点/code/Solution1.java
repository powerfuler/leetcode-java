package q021_030.q024_两两交换链表中的节点.code;

import entity.ListNode;

/**
 * 递归
 *
 */
public class Solution1 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
