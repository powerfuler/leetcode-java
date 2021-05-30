package q011_020.q019_删除链表的倒数第N个节点;

/*
 */

import q011_020.q019_删除链表的倒数第N个节点.code.Solution1;
import utils.entity.ListNode;

public class Test {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        long t1 = System.currentTimeMillis();
        ListNode listNode = new Solution1().removeNthFromEnd(n1, 5);
        long t2 = System.currentTimeMillis();

        System.out.println(listNode);
    }
}
