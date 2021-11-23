package company.bytedance.q201_q300.q0232_1.code;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 我们创建两个栈，分别为 `out` 和 `in`：
 *
 * `in` 用作处理输入操作 `push()`，使用 `in` 时需确保 `out` 为空
 * `out` 用作处理输出操作 `pop()` 和 `peek()`，使用 `out` 时需确保 `in` 为空
 */
class MyQueue1 {
    Deque<Integer> out, in;

    public MyQueue1() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!out.isEmpty()) {
            in.addLast(out.pollLast());
        }
        in.addLast(x);
    }

    public int pop() {
        while (!in.isEmpty()) {
            out.addLast(in.pollLast());
        }
        return out.pollLast();
    }

    public int peek() {
        while (!in.isEmpty()) {
            out.addLast(in.pollLast());
        }
        return out.peekLast();
    }

    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue1 myQueue = new MyQueue1();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}