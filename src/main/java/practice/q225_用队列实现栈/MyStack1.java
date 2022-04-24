package practice.q225_用队列实现栈;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack1 {

    Deque<Integer> in, out;

    public MyStack1() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(int x) {// 将元素 x 压入栈顶。
        in.offer(x);
        while (!out.isEmpty()) {
            in.offer(out.poll());
        }

        Deque<Integer> tem = out;
        out = in;
        in = tem;
    }

    public int pop() { //移除并返回栈顶元素。
        return out.poll();
    }

    public int top() {// 返回栈顶元素。
        return out.peek();
    }

    public boolean empty() { //如果栈是空的，返回 true ；否则，返回 false 。
        return out.isEmpty();
    }

}
