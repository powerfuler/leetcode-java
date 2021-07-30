package company.bytedance.q201_q300.q0234_1.code;

import utils.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 把链表转为List数组
 * 根据数组长度，找到中间位置
 * 从前往后取数组的值与从后往前取数组，进行比较
 * 效率低
 */
public class Solution3 {
    public boolean isPalindrome(ListNode head) {
        // 链表转数组
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.toArray().length];
        int temp = 0;
        for (int a : list) {
            arr[temp++] = a;
        }
        temp = 0;
        // 从前后取数据依次比较
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] == arr[arr.length - i - 1]) {
                temp++;
            }
        }
        // 奇数取上 中间数据不需要比较，中间折叠对称比较
        if (temp == arr.length / 2) return true;
        return false;
    }
}