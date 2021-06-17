package company.bytedance.q0206_1.code;


import utils.structure.ListNode;

/**
 * 遍历直接反向修改next指针 o(n)
 */
class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode t = temp.next;
            temp.next = pre;
            pre = temp;
            temp = t;
        }
        return pre;
    }
}