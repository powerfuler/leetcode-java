package company.bytedance.q201_q300.q0232_1.code;

import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    Deque<Integer> out, in;

    public MyQueue() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }

    public void push(int x) {
        in.addLast(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.addLast(in.pollLast());
            }
        }
        return out.pollLast();
    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.addLast(in.pollLast());
            }
        }
        return out.peekLast();
    }

    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2]
        myQueue.push(3);
        myQueue.push(4); // queue is: [1, 2, 3, 4]
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2, 3, 4]
        myQueue.push(5);
        myQueue.push(6); // queue is [2, 3, 4, 5, 6]
        myQueue.peek(); // return 2
        myQueue.peek(); // return 2
        myQueue.pop(); // return 2, queue is [3, 4, 5, 6]
        myQueue.pop(); // return 3, queue is [4, 5, 6]
        myQueue.peek(); // return 4
        myQueue.empty(); // return false

        myQueue.pop(); // return 4, queue is [5, 6]
        myQueue.pop(); // return 5, queue is [6]
        myQueue.pop(); // return 6, queue is []
        myQueue.empty(); // return true
    }
}