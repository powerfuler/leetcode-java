package company.bytedance.q0141_1.code;

import utils.structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表 o(n)
 */
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
