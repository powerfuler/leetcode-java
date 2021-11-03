package company.bytedance.q101_q200.q0150_1.code;

import java.util.Stack;

/**
 * 自带栈解法
 */
class Solution3 {
    public int evalRPN(String[] ts) {
        Stack<Integer> d = new Stack<>();
        for (String s : ts) {
            if ("+-*/".contains(s)) {
                int b = d.pop();
                int a = d.pop();
                d.push(calc(a, b, s));
            }  else {
                d.push(Integer.parseInt(s));
            }
        }
        return d.peek();
    }
    int calc(int a, int b, String op) {
        if (op.equals("+")) return a + b;
        else if (op.equals("-")) return a - b;
        else if (op.equals("*")) return a * b;
        else if (op.equals("/")) return a / b;
        else return -1;
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"4","13","5","/","+"};
        int i = new Solution3().evalRPN(tokens);
        System.out.println(i);
    }
}