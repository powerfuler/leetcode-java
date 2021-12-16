package company.bytedance.q201_q300.q0225_1.code;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    // 你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）
    Queue<Integer> in, out;

    public MyStack() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(int x) {
        in.offer(x);
        while (!out.isEmpty()) {
            in.offer(out.poll());
        }
        Queue<Integer> temp = out;
        out = in;
        in = temp;
    }

    public int pop() {
        return out.poll();
    }

    public int top() {
        return out.peek();
    }

    public boolean empty() {
        return out.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.empty();

    }
}