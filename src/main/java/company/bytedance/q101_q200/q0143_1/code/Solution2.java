package company.bytedance.q101_q200.q0143_1.code;

import utils.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.把每个Node存到List<ListNode>
 * 2.依次取头尾数据，把尾指针数据放到头指针 list.get(i).next = list.get(i);
 * 3.list.get(0) 就是排序好的ListNode
 *
 */
public class Solution2 {
    public ListNode reorderList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 存到 list 中去
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        //头尾指针依次取元素
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            //偶数个节点的情况，会提前相遇
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
        return list.get(0);
    }
}