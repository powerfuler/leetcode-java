package practice2.q023_合并K个排序链表.code;

import utils.entity.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 优先级队列:
 * 时间复杂度：O(n*log(k))O(n∗log(k))，n 是所有链表中元素的总和，k 是链表个数。
 */
public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        // 创建PriorityQueue，比较值为val
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 将数组中的值，转移到PriorityQueue中
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        while (!pq.isEmpty()) {
            //拿到首位  poll();返回第一个对象并移除 peek();只返回不移除
            //规则，拿到值首位值最小链表，将第一位添加到需要返回的链表,如果该链表尚未结束，再添加回PriorityQueue中
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }
}