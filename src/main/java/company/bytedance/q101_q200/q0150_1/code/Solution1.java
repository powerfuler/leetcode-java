package company.bytedance.q101_q200.q0150_1.code;

/**
 *
 *   用数据结构`栈`来解决这个问题。
 *
 *   数字栈，数组模拟栈解法
 *
 * - 从前往后遍历数组
 * - 遇到数字则压入栈中
 * - 遇到符号，则把栈顶的两个数字拿出来运算，把结果再压入栈中
 * - 遍历完整个数组，栈顶数字即为最终答案
 */
public class Solution1 {

    public int evalRPN(String[] ts) {
        int[] d = new int[ts.length];
        int hh = 0, tt = -1;
        for (String s : ts) {
            if ("+-*/".contains(s)) {
                int b = d[tt--], a = d[tt--];
                d[++tt] = calc(a, b, s);
            } else {
                d[++tt] = Integer.parseInt(s);
            }
        }
        return d[tt];
    }

    int calc(int a, int b, String op) {
        if (op.equals("+")) return a + b;
        else if (op.equals("-")) return a - b;
        else if (op.equals("*")) return a * b;
        else if (op.equals("/")) return a / b;
        else return -1;
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        int i = new Solution1().evalRPN(tokens);
        System.out.println(i);
    }
}