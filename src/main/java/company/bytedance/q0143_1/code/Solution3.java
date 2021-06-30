package company.bytedance.q0143_1.code;

import utils.structure.ListNode;

import java.util.LinkedList;

/**
 * 1.把每个Node存到LinkedList<ListNode>
 * 2.依次取头尾数据，把尾指针数据放到头指针 list.get(i).next = list.get(i);
 * 3.list.get(0) 就是排序好的ListNode
 *
 */
public class Solution3 {
    public void reorderList(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            queue.addLast(cur);
            cur = cur.next;
        }
        while (!queue.isEmpty()) {
            if (cur == null) {
                cur = queue.pollFirst();
            } else {
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            cur.next = queue.pollLast();
            cur = cur.next;
        }
        if (cur != null) {
            cur.next = null;
        }
    }
}