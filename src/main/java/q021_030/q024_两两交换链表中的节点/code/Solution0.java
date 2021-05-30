package q021_030.q024_两两交换链表中的节点.code;

import utils.entity.ListNode;

/**
 * 解题思路
 * 使用一个头结点root来辅助操作，对要进行交换的链表，每两个的位置进行交换，
 * 并且把交换后的结点接到root的链表上，直到所有的结点都处理完。
 */
public class Solution0 {
    public ListNode swapPairs(ListNode head) {
        // 头结点
        ListNode node = new ListNode(0);
        node.next = head;
        // p指向新的链表的尾结点，p指向处理好的结点，添加的头结点认为已经处理好了
        ListNode p = node;
        ListNode tmp;
        // 每两个进行操作
        while (p.next != null && p.next.next != null) {
            // 记录下一次要进行处理的位置
            tmp = p.next.next;
            // 下面三句完成两个结点交换
            p.next.next = tmp.next;
            tmp.next = p.next;
            p.next = tmp;
            // 指向返回链表的新的尾结点
            p = tmp.next;
        }
        head = node.next;
        node.next = null;
        return head;
    }
}
