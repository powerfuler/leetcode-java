package q021_030.q021_合并两个有序链表.code;

import utils.entity.ListNode;

/**
 * 递归（看成两个链表头部较小的一个与剩下元素的 merge 操作结果合并） o(n)
 */
public class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}