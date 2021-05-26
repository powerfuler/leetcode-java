package q011_020.q019_删除链表的倒数第N个节点.code;

import entity.ListNode;

public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode index1 = head, index2 = head;
        for(int i = 0; i < n; i++) {
            //使得index1与index2之间间隔n-1个节点
            index2 = index2.next;
        }
        if(index2 == null) {
            //说明删除的是头节点
            return head.next;
        }
        //将index2移至最后一个节点
        while(index2.next != null){
            index2 = index2.next;
            index1 = index1.next;
        }
        index1.next = index1.next.next;
        return head;
    }
}