package company.bytedance.q801_q900.q876_链表的中间结点;

/**
 * 快慢指针法 o(n)
 */
public class Solution {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
