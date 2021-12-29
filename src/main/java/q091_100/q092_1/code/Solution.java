package q091_100.q092_1.code;

import utils.structure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        // 定假节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;

        for (int j = 1; j < right; j++) {
            head = head.next;
        }
        ListNode next = head.next;
        head.next = null;

        pre.next = reverseList(start);
        start.next = next;

        return dummy.next;
    }

    //输入: 1->2->3->4->5->NULL
    //输出: 5->4->3->2->1->NULL
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.createTestData("[1,2,3,4,5,6,7,8,9,10,11]");
//        ListNode reverse = new gp.DFS.L78.Solution().reverseList(l1);
        ListNode reverse = new Solution().reverseBetween(l1, 3, 9);
        ListNode.print(reverse);
    }
}