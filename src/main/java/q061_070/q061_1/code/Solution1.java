package q061_070.q061_1.code;

import utils.structure.ListNode;

/**
 *
 *
 */
public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode head2 = new ListNode(0, head);
        int count = 0;
        while (head2.next != null) {
            head2 = head2.next;
            ++count; // 求出链表长度
        }
        head2.next = head;
        k %= count;
        // 为的是找到倒数第n个结点
        k = count - k;
        while (k > 0) {
            head2 = head2.next;
            head = head.next;
            k--;
        }
        head2.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = ListNode.createTestData("[1,2,3,4,5]");
        long t4 = System.currentTimeMillis();
        ListNode listNode = new Solution1().rotateRight(n1, 2);
    }
}