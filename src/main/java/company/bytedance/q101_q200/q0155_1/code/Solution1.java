package company.bytedance.q101_q200.q0155_1.code;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ### 双栈解法
 *
 * 为了快速找到栈中最小的元素，我们可以使用一个辅助栈 help。
 * 通过控制 help 的压栈逻辑来实现：*help 栈顶中始终存放着栈内元素的最小值。*
 *
 */
public class Solution1 {
    Deque<Integer> data = new ArrayDeque<>();
    Deque<Integer> help = new ArrayDeque<>();

    public void push(int val) {
        data.addLast(val);
        if (help.isEmpty() || help.peekLast() >= val) {
            help.addLast(val);
        } else {
            help.addLast(help.peekLast());
        }
    }

    public void pop() {
        data.pollLast();
        help.pollLast();
    }

    public int top() {
        return data.peekLast();
    }

    public int getMin() {
        return help.peekLast();
    }

    public static void main(String[] args) {

        Solution1 minStack = new Solution1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-6);
        minStack.push(3);

        int min = minStack.getMin();//--> 返回 -3.
        minStack.pop();
        int top = minStack.top();// --> 返回 0.
        min = minStack.getMin();  // --> 返回 -2.
    }
}