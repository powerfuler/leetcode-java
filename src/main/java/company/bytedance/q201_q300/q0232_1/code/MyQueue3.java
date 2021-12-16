package company.bytedance.q201_q300.q0232_1.code;

import java.util.Stack;

// 请你仅使用两个栈实现先入先出队列
class MyQueue3 {
    Stack<Integer> in; // 负责入队
    Stack<Integer> out; // 负责出队

    public MyQueue3() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}