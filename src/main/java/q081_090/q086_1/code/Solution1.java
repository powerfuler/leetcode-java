package q081_090.q086_1.code;

import utils.structure.ListNode;

/**
 * - 设定两个虚拟节点，`dummyHead1 `用来保存小于于该值的链表，`dummyHead2 `来保存大于等于该值的链表
 * - 遍历整个原始链表，将小于该值的放于`dummyHead1 `中，其余的放置在`dummyHead2 `中
 * - 遍历结束后，将`dummyHead2 `插入到`dummyHead1 `后面
 *
 */
public class Solution1 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        ListNode prev1 = dummyHead1;
        ListNode prev2 = dummyHead2;

        for (ListNode cur = head; cur != null; ) {
            if (cur.val < x) {
                prev1.next = cur;
                cur = cur.next;
                prev1 = prev1.next;
                prev1.next = null;
            } else {
                prev2.next = cur;
                cur = cur.next;
                prev2 = prev2.next;
                prev2.next = null;
            }
        }
        // 拼接到后面
        prev1.next = dummyHead2.next;

        return dummyHead1.next;
    }

    public static void main(String[] args) {
        ListNode a = ListNode.createTestData("[1,4,3,2,5,2]");
        ListNode partition = new Solution1().partition(a, 3);
        ListNode.print(partition);
    }
}