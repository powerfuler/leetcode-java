package company.bytedance.q025_1.code;

import utils.entity.ListNode;

/**
 * 步骤分解:
 *
 * 链表分区为已翻转部分+待翻转部分+未翻转部分
 * 每次翻转前，要确定翻转链表的范围，这个必须通过 k 此循环来确定
 * 需记录翻转链表前驱和后继，方便翻转完成后把已翻转部分和未翻转部分连接起来
 * 初始需要两个变量 pre 和 end，pre 代表待翻转链表的前驱，end 代表待翻转链表的末尾
 * 经过k此循环，end 到达末尾，记录待翻转链表的后继 next = end.next
 * 翻转链表，然后将三部分链表连接起来，然后重置 pre 和 end 指针，然后进入下一次循环
 * 特殊情况，当翻转部分长度不足 k 时，在定位 end 完成后，end==null，已经到达末尾，说明题目已完成，直接返回即可
 * 时间复杂度为 O(n*K) 最好的情况为 O(n) 最差的情况未 O(n^2)
 * 空间复杂度为 O(1) 除了几个必须的节点指针外，我们并没有占用其他空间
 */
public class Solution1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义一个假的节点。
        ListNode dummy = new ListNode(0);
        //假节点的next指向head。
        // dummy->1->2->3->4->5
        dummy.next = head;
        //初始化pre和end都指向dummy。pre指每次要翻转的链表的头结点的上一个节点。end指每次要翻转的链表的尾节点
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            //循环k次，找到需要翻转的链表的结尾,这里每次循环要判断end是否等于空,因为如果为空，end.next会报空指针异常。
            //dummy->1->2->3->4->5 若k为2，循环2次，end指向2
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
            if (end == null) {
                break;
            }
            //先记录下end.next,方便后面链接链表
            ListNode next = end.next;
            //然后断开链表
            end.next = null;
            //记录下要翻转链表的头节点
            ListNode start = pre.next;
            //翻转链表,pre.next指向翻转后的链表。1->2 变成2->1。 dummy->2->1
            pre.next = reverse1(start);
            //翻转后头节点变到最后。通过.next把断开的链表重新链接。
            start.next = next;
            //将pre换成下次要翻转的链表的头结点的上一个节点。即start
            pre = start;
            //翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start
            end = start;
        }
        return dummy.next;
    }

    //链表翻转
    // 例子：   head： 1->2->3->4
    public ListNode reverse(ListNode head) {
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

    private ListNode reverse1(ListNode head) {
        ListNode newLink = null;
        ListNode curr = head;
        //每次循环：处理当前节点，使其指向新链表，curr指针后移；
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
