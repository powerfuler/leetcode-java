package company.bytedance.q201_q300.q0206_1.code;

import utils.structure.ListNode;

//输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
public class Solution5 {
    public ListNode reverseList(ListNode head) {
        ListNode pre, current, next;
        pre = null;
        current = head;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.createTestData("[2,4,5,6,7]");
        ListNode reverse = new Solution5().reverseList(l1);
        ListNode.print(reverse);
    }
}
