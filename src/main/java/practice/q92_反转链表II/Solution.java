package practice.q92_反转链表II;

import utils.structure.ListNode;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        for (int j = 0; j < right; j++) {
            end = end.next;
        }
        ListNode next = end.next;
        end.next = null;

        pre.next = reverseList(start);

        start.next = next;

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
        ListNode l1 = ListNode.createTestData("[1,2,3,4,5,6,7,8,9]");
        ListNode reverse = new Solution().reverseBetween(l1, 3, 7);
        ListNode.print(reverse);
    }
}