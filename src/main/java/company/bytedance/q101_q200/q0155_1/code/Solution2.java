package company.bytedance.q101_q200.q0155_1.code;

import java.util.Stack;

/**
 * 不使用辅助栈，每次push两个元素
 */
public class Solution2 {

    private Stack<Integer> stack;

    public Solution2() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            int tmp = stack.peek();
            stack.push(x);
            if (tmp < x) {
                stack.push(tmp);
            } else {
                stack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size() - 2);
    }

    public int getMin() {
        return stack.peek();
    }
}
