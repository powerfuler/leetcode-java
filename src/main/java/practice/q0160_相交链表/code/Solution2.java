package practice.q0160_相交链表.code;

import utils.structure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 栈解法
 * 将两条链表分别压入两个栈中，然后循环比较两个栈的栈顶元素，同时记录上一位栈顶元素。
 * 当遇到第一个不同的节点时，结束循环，上一位栈顶元素即是答案。
 *
 * 时间复杂度：$O(n + m)$
 * 空间复杂度：$O(n + m)$
 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        Deque<ListNode> d1 = new ArrayDeque(), d2 = new ArrayDeque();
        while (a != null) {
            d1.addLast(a);
            a = a.next;
        }
        while (b != null) {
            d2.addLast(b);
            b = b.next;
        }
        ListNode ans = null;
        while (!d1.isEmpty() && !d2.isEmpty() && d1.peekLast().equals(d2.peekLast())) {
            ListNode c1 = d1.pollLast(), c2 = d2.pollLast();
            ans = c1;
        }
        return ans;
    }
}