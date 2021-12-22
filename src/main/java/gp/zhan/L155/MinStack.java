package gp.zhan.L155;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack ;
    Stack<Integer> min;

    public MinStack(){
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(min.isEmpty()){
            min.push(val);
        } else {
            if(min.peek() <= val){
                min.push(min.peek());
            } else {
                min.push(val);
            }
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}