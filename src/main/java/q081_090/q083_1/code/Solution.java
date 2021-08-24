package q081_090.q083_1.code;

import utils.structure.ListNode;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = ListNode.createTestData("[1,2,3,3,3,4,4,5,6,6,7]");
        ListNode resp = solution.deleteDuplicates(node);
        ListNode.print(resp);
    }
}