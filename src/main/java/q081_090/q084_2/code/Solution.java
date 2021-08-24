package q081_090.q084_2.code;

import java.util.Stack;

/**
 * 单调栈,就是在这一个高度下的最大面积，向左向右延伸的最大距离（宽）
 *
 * 1、对于一个高度，如果能得到向左和向右的边界
 * 2、那么就能对每个高度求一次面积
 * 3、遍历所有高度，即可得出最大面积
 * 4、使用单调栈，在出栈操作时得到前后边界并计算面积
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i <= n; ++i) {
            // curElement 表示当前元素的值，用 -1 表示数组的结束
            int curElement = (i == n) ? -1 : heights[i];
            // 元素的出栈操作，表明当前栈顶元素找到了右边界
            // 加上栈内存放的元素是单调递增的，因此左边界也找到了
            // while 里面针对栈顶元素这个高度的矩形计算面积即可
            while (!stack.isEmpty() && heights[stack.peek()] >= curElement) {
                int high = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                result = Math.max(result, high * width);
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 1, 5, 6, 2, 3, 6, 5, 4, 1, 6};
        int resp = new Solution().largestRectangleArea(a);
        System.out.println(resp);
    }
}