package q002_两数相加;

import q002_两数相加.code.ListNode;
import q002_两数相加.code.Solution1;
import utils.CommonUtil;

/*
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
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

//        ListNode nodeSta = new ListNode(0);    //创建首节点
//        ListNode nextNode;                     //声明一个变量用来在移动过程中指向当前节点
//        nextNode=nodeSta;                      //指向首节点
//        //创建链表
//        for(int i=1;i<4;i++){
//            ListNode node = new ListNode(i);  //生成新的节点
//            nextNode.next=node;               //把心节点连起来
//            nextNode=nextNode.next;           //当前节点往后移动
//        } //当for循环完成之后 nextNode指向最后一个节点，
//
//        nextNode=nodeSta;                     //重新赋值让它指向首节点
//        CommonUtil.print(listNode1);                      //打印输出
        CommonUtil.print(listNode2);
    }

}
