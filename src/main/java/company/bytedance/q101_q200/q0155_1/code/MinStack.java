package company.bytedance.q101_q200.q0155_1.code;

import java.util.Stack;

/**
 * 为了能在常数时间内检测到栈中的最小元素，我们可以通过"空间换时间"的方式进行实现，
 * 为栈本身（数据栈\_data）增加一个辅助栈（最小值栈\_min）。
 * 每一次元素入 \_data 栈，则在 \_min 栈中增加对应的最小值；当 \_data 栈中的元素出栈，则 \_min 栈也进行出栈操作
 */
class MinStack {

    private Stack<Integer> _data;
    private Stack<Integer> _min;

    public MinStack() {
        _data = new Stack<>();
        _min = new Stack<>();
    }

    public void push(int x) {
        _data.add(x);
        if (_min.isEmpty()) {
            _min.push(x);
        } else {
            if (x > _min.peek()) {
                x = _min.peek();
            }
            _min.push(x);
        }
    }

    public void pop() {
        _data.pop();
        _min.pop();
    }

    public int top() {
        return _data.peek();
    }

    public int getMin() {
        return _min.peek();
    }
}