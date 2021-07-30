package company.bytedance.q201_q300.q0206_1.code;

import utils.structure.ListNode;

/**
 * 链表翻转
 * 例子：   head： 1->2->3->4
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null) {
            return head;
        }
        //前一个节点指针
        ListNode preNode = null;
        //当前节点指针
        ListNode curNode = head;
        //下一个节点指针
        ListNode nextNode = null;
        while (curNode != null) {
            //nextNode 指向下一个节点,保存当前节点后面的链表。
            nextNode = curNode.next;
            //将当前节点next域指向前一个节点   null<-1<-2<-3<-4
            curNode.next = preNode;
            //preNode 指针向后移动。preNode指向当前节点。
            preNode = curNode;
            //curNode指针向后移动。下一个节点变成当前节点
            curNode = nextNode;
        }
        return preNode;
    }
}