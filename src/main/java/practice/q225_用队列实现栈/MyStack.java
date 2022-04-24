package practice.q225_用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
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
}