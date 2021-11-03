package company.bytedance.q101_q200.q0148_1.code;

import utils.structure.ListNode;

/**
 * 使用插入排序
 * 想要排序块，就要尽可能少的做比较
 * 需要一个指针指向当前已排序的最后一个位置，这里用的是head指针
 * 需要另外一个指针pre,每次从表头循环，这里用的是dummy表头指针。
 * 每次拿出未排序的节点，先和前驱比较，如果大于或者等于前驱，就不用排序了，直接进入下一次循环
 * 如果前驱小，则进入内层循环，依次和pre指针比较，插入对应位置即可。
 */
public class Solution2 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0), pre;
        dummy.next = head;

        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;

            while (pre.next.val < head.next.val) {
                pre = pre.next;
            }
            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = ListNode.createTestData("[-1,5,3,4,0,2,1]");

        ListNode node = new Solution2().insertionSortList(a);
        ListNode.print(node);
    }
}