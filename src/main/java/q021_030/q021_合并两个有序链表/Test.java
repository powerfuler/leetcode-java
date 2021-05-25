package q021_030.q021_合并两个有序链表;

/*
 */


import q021_030.q021_合并两个有序链表.code.Solution1;
import utils.ListNode;

public class Test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n4.next = n5;
        n5.next = n6;


        long t1 = System.currentTimeMillis();
        ListNode listNode = new Solution1().mergeTwoLists(n1, n4);
        long t2 = System.currentTimeMillis();

        System.out.println(listNode);
    }
}
