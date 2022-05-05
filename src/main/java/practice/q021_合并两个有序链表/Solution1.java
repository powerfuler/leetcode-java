package practice.q021_合并两个有序链表;

import utils.entity.ListNode;

/**
 * 递归（看成两个链表头部较小的一个与剩下元素的 merge 操作结果合并） o(n)
 */
public class Solution1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}