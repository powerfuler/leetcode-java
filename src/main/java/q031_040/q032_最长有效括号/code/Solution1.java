package q031_040.q032_最长有效括号.code;

import java.util.Stack;

/**
 * 解题思路一：常规
 * 利用索引栈 o(n)
 *
 * 对于这种括号匹配问题，一般都是使用栈
 * 我们先找到所有可以匹配的索引号，然后找出最长连续数列！
 * 例如：s = )(()())，我们用栈可以找到，
 * 位置 2 和位置 3 匹配，
 * 位置 4 和位置 5 匹配，
 * 位置 1 和位置 6 匹配，
 * 这个数组为：2,3,4,5,1,6 这是通过栈找到的，我们按递增排序！1,2,3,4,5,6
 *
 * 找出该数组的最长连续数列的长度就是最长有效括号长度！
 * 所以时间复杂度来自排序：O(nlogn)。
 *
 * 接下来我们思考，是否可以省略排序的过程,在弹栈时候进行操作呢?
 * 直接看代码理解!所以时间复杂度为：O(n)O(n)。
 *
 */
public class Solution1 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}