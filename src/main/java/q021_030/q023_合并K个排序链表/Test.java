package q021_030.q023_合并K个排序链表;

/*
 */

import entity.ListNode;
import q021_030.q023_合并K个排序链表.code.Solution4;

public class Test {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;


        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(3);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(6);
        l21.next = l22;

        ListNode[] lists = {l1, l11, l21};

        System.out.println(new Solution4().mergeKLists(lists));

    }
}
