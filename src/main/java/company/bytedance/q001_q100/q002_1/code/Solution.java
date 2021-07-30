package company.bytedance.q001_q100.q002_1.code;

import utils.structure.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sumHead = new ListNode(-1);
        ListNode sumNode = sumHead;   
        while (l1 != null || l2 != null) {
            // 求和
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            sumNode.next = new ListNode(sum);
            // 三个指针后移
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            sumNode = sumNode.next;
        }
        if (carry != 0) {
            sumNode.next = new ListNode(carry);
        }
        return sumHead.next;
    }
}