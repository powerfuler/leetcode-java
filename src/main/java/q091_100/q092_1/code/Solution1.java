package q091_100.q092_1.code;

import utils.structure.ListNode;

/**
 *
 *
 */
public class Solution1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        right -= left;
        ListNode hh = dummy;
        while (left-- > 1) {
            hh = hh.next;
        }
        ListNode a = hh.next,
                b = a.next;
        // 翻转
        while (right-- > 0) {
            ListNode tmp = b.next;
            b.next = a;
            a = b;
            b = tmp;
        }
        // 连接
        hh.next.next = b;
        hh.next = a;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = ListNode.createTestData("[1,2,3,4,5]");
        ListNode node = new Solution1().reverseBetween(a, 2, 4);
        ListNode.print(node);
    }
}