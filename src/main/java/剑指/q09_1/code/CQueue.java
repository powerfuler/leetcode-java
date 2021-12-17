package 剑指.q09_1.code;

import java.util.Stack;

class CQueue {

    Stack<Integer> in, out;

    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        if(out.isEmpty()){
            return -1;
        }
       return out.pop();
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.deleteHead();
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        cQueue.deleteHead();
        cQueue.deleteHead();
        cQueue.deleteHead();

//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//        输出：[null,-1,null,null,5,2]
    }
}