package practice.q025_K个一组翻转链表;

import utils.structure.ListNode;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        ListNode start = pre.next;

        while (end.next != null) {
            for (int j = 0; j < k && end != null; j++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode next = end.next;
            end.next = null;

            pre.next = reverseList(start);

            start.next = next;
            pre = start;
            end = start;
            start = pre.next;
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
        ListNode l1 = ListNode.createTestData("[1,2,3,4,5,6,7,8]");
        ListNode reverse = new Solution().reverseKGroup(l1, 3);
        ListNode.print(reverse);
    }
}