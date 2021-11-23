package 剑指.q022_1.code;

import utils.structure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 栈/队列 解法
 *
 * 一个使用额外空间的解法是利用栈（队列），将所有的节点压入占中栈（队列）中，令当前栈（队列）容量为 $cnt$。
 *
 * 然后从栈顶（队列头）弹出 $k$ 个（$cnt - k + 1$ 个）元素，最后一个出栈（出队列）的元素即是答案。
 *
 */
public class Solution1 {
    // 栈
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> d = new Stack<>();
        while (head != null) {
            d.push(head);
            head = head.next;
        }
        ListNode ans = null;
        while (k-- > 0) {
            ans = d.pop();
        }
        return ans;
    }

    // 队列
    public ListNode getKthFromEnd1(ListNode head, int k) {
        Deque<ListNode> d = new ArrayDeque<>();
        while (head != null) {
            d.addLast(head);
            head = head.next;
        }
        k = d.size() - k + 1;
        ListNode ans = null;
        while (k-- > 0) {
            ans = d.pollFirst();
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode a= ListNode.createTestData("[1,2,3,4,5]");
        ListNode kthFromEnd = new Solution1().getKthFromEnd1(a, 2);
        ListNode.print(kthFromEnd);
    }
}