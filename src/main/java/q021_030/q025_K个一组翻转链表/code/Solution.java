package q021_030.q025_K个一组翻转链表.code;


import utils.structure.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode next = end.next;

            end.next = null;
            ListNode start = pre.next;
            pre.next = reverseList(start);

            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.createTestData("[1,2]");
        ListNode reverse = new Solution().reverseKGroup(l1, 2);
        ListNode.print(reverse);
    }
}
