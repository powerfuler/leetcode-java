package q1_1;

import q2_两数相加.code.ListNode;
import q2_两数相加.code.Solution1;
import utils.CommonUtil;

/*
*/

public class Test {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode addnode2 = new ListNode(4);
        l1.next = addnode2;
        ListNode addnode3 = new ListNode(9);
        addnode2.next = addnode3;

        ListNode l2 = new ListNode(4);
        ListNode addnode4 = new ListNode(6);
        l2.next = addnode4;
//        ListNode addnode5 = new ListNode(5);
//        addnode4.next = addnode5;

        long t1 = System.currentTimeMillis();
//        ListNode listNode1 = new Solution2().addTwoNumbers(l2, l1);
        long t2 = System.currentTimeMillis();

        long t4 = System.currentTimeMillis();
        ListNode listNode2 = new Solution1().addTwoNumbers(l2, l1);
        long t5 = System.currentTimeMillis();

        System.out.println("time cost is " + (t2 - t1) + " ms;");
        System.out.println("time cost is " + (t5 - t4) + " ms;");

//        CommonUtil.print(listNode1);                      //打印输出
        CommonUtil.print(listNode2);
    }

}
