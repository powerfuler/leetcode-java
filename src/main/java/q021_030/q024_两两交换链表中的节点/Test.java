package q021_030.q024_两两交换链表中的节点;

/*
*/

import utils.entity.ListNode;
import q021_030.q024_两两交换链表中的节点.code.Solution0;

public class Test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        long t1 = System.currentTimeMillis();
        ListNode listNode = new Solution0().swapPairs(n1);
        long t2 = System.currentTimeMillis();

        System.out.println(listNode);

    }
}
