package q081_090.q083_1.code;

import utils.structure.ListNode;

/**
 * 1. 建一个「虚拟头节点」dummy 以减少边界判断，往后的答案链表会接在 dummy 后面
 * 2. 使用 tail 代表当前有效链表的结尾
 * 3. 通过原输入的 head 指针进行链表扫描
 *
 */
public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-109);
        ListNode tail = dummy;
        while (head != null) {
            // 值不相等才追加，确保了相同的节点只有第一个会被添加到答案
            if (tail.val != head.val) {
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        ListNode node = ListNode.createTestData("[1,2,3,3,3,4,4,5,6,6,7]");
        ListNode resp = solution.deleteDuplicates(node);
        ListNode.print(resp);
    }
}