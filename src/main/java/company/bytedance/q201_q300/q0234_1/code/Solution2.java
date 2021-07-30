package company.bytedance.q201_q300.q0234_1.code;

import utils.structure.ListNode;

/**
 * 链表加头节点
 * 使用快慢指针来确定中间结点，慢指针走一位，快指针一下走两位
 * 慢指针的位置即为中间节点
 * 反转后半部分链表，中间点后面的一个节点
 * 将前半部分链表和后半部分进行比较,存在不等则返回
 */
public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode p = new ListNode(-1);
        ListNode low = p;
        ListNode fast = p;
        p.next = head;
        // 使用快慢指针来确定中间结点
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        ListNode cur = low.next;
        ListNode pre = null;
        low.next = null;
        low = p.next;

        // 反转后半部分链表
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        // 将前半部分链表和后半部分进行比较
        while (pre != null) {
            if (low.val != pre.val) {
                return false;
            }
            low = low.next;
            pre = pre.next;
        }
        return true;
    }
}