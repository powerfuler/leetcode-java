package company.bytedance.q0143_1.code;

import utils.structure.ListNode;

/**
 * 1.快慢指针找到中点
 * 2.拆成两个链表
 * 3.遍历两个链表，后面的塞到前面的“缝隙里”
 *
 */
public class Solution1 {
    public ListNode reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        //找中点，链表分成两个
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        //第二个链表倒置
        newHead = reverseList(newHead);

        ListNode result = head;
        //链表节点依次连接
        while (newHead != null) {
            ListNode temp = newHead.next;

            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;

            newHead = temp;
        }
        return result;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        head = head.next;
        tail.next = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;
    }
}