package company.bytedance.q101_q200.q0160_1.code;

import utils.structure.ListNode;

/**
 *
 * 朴素双循环
 * 时间复杂度：$O(n * m)$
 * 空间复杂度：$O(1)$
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        for (ListNode h1 = a; h1 != null; h1 = h1.next) {
            for (ListNode h2 = b; h2 != null; h2 = h2.next) {
                if (h1.equals(h2))
                    return h1;
            }
        }
        return null;
    }
}