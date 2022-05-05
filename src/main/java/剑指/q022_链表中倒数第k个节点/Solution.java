package 剑指.q022_链表中倒数第k个节点;

import utils.structure.ListNode;

/**
 * 快慢指针
 * 起始先让快指针 `fast` 先走 $k$ 步，此时 `fast` 和 `slow` 之间距离为 $k$，之后让 `fast` 和 `slow` 指针一起走（始终维持相对距离为 $k$），
 * 当 `fast` 到达链表尾部，`slow` 即停在倒数第 $k$ 个节点处。
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode a= ListNode.createTestData("[1,2,3,4,5]");
        ListNode kthFromEnd = new Solution().getKthFromEnd(a, 2);
        ListNode.print(kthFromEnd);
    }
}