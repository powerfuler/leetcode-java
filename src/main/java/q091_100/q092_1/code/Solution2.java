package q091_100.q092_1.code;

import utils.structure.ListNode;

class Solution2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dum = new ListNode(-1);
        dum.next = head;

        ListNode cur = dum;
        ListNode pre, front = null, last;

        for (int i = 1; i <= left - 1; ++i) {
            cur = cur.next;
        }

        pre = cur;
        last = cur.next;

        for (int i = left; i <= right; ++i) {
            cur = pre.next;
            pre.next = cur.next;
            cur.next = front;
            front = cur;
        }
        cur = pre.next;
        pre.next = front;
        last.next = cur;
        return dum.next;
    }

    public static void main(String[] args) {
        ListNode a = ListNode.createTestData("[1,2,3,4,5]");
        ListNode node = new Solution2().reverseBetween(a, 2, 4);
        ListNode.print(node);
    }
}