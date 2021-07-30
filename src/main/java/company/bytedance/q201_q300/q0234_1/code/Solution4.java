package company.bytedance.q201_q300.q0234_1.code;

import utils.structure.ListNode;

import java.util.LinkedList;

/**
 * 栈从头入栈
 * 弹出链表尾数据
 * 在比较
 */
class Solution4 {
    public boolean isPalindrome(ListNode head) {
        // 遇到了这道题，当时想到用的栈，回来看发现之前没这么做过，来做一做
        LinkedList<Integer> stack = new LinkedList<Integer>();
        ListNode tmp = head;
        while(tmp != null){
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        ListNode tmp2 = head;
        while(tmp2 != null){
            if(tmp2.val != stack.pop()){
                return false;
            }
            tmp2 = tmp2.next;
        }
        return true;
    }
}