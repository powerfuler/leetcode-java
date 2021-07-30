package company.bytedance.q201_q300.q0206_1.code;

import utils.structure.ListNode;

/**
 * 链表翻转
 * 例子：   head： 1->2->3->4
 */
public class Solution3 {
    public ListNode reverseList(ListNode head) {
        ListNode newLink = null;
        ListNode curr = head;
        // 每次循环：处理当前节点，使其指向新链表，curr指针后移；
        // 未处理链表和新链表没有直接关系，但循环直到未处理链表为空
        while (curr != null) {
            //保存未处理的
            ListNode unReversed = curr.next;
            //当前节点指向新链表
            curr.next = newLink;
            //保存
            newLink = curr;
            //未处理链表作为当前节点
            curr = unReversed;
        }
        return newLink;
    }
}

