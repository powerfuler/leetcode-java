package company.bytedance.q0142_1.code;

import utils.structure.ListNode;

/**
 * 双指针法
 * 总结关键点：
 *
 * 思路
 * 假设链表环前有 a 个节点，环内有 b 个节点
 * 本题核心思路：走 a+nb 步一定处于环的入口位置
 *
 * 利用快慢指针 fast 和 slow，fast 一次走两步，slow 一次走一步
 * 当两个指针第一次相遇时，假设 slow 走了 s 步，下面计算 fast 走过的步数
 * i. fast 比 slow 多走了 n 个环：f=s+nb
 * ii. fast 比 slow 多走一倍的步数：f=2s --> 跟上式联立可得 s=nb
 * iii. 综上计算得，f=2nb，s=nb
 * 也就是两个指针第一次相遇时，都走过了环的倍数，那么再走 a 步就可以到达环的入口
 * 让 fast 从头再走，slow 留在原地，fast 和 slow 均一次走一步，当两个指针第二次相遇时，fast 走了 a 步，slow 走了 a+nb 步
 * 此时 slow 就在环的入口处，返回 slow
 *
 *
 */
public class Solution1 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}